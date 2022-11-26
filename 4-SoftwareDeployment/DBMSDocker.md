### Кроки роботи з Dockerобразом та створюємим Docker-контейнером для СКБД

#### Створення БД

1. Завантажуємо образ СКБД PostgreSql:

`docker pull postgres`

2. Запускаємо контейнер за завантаженим образом СКБД, враховуємо, що

	- Назва контейнеру tomchuk-postgres
	- Порт 5432
	- Змінна оточення `POSTGRES_PASSWORD`, що вказує на пароль створеного користувача дорівнює `postgres`
	- Створюємо робочий каталог з додатковими файлами у файловій системі нового Docker-образу
	- Встановлюємо зв’язок між локальним каталогом комп’ютера та робочим каталогом
	- Запускаємо у фоновому режимі
	
`docker run --name tomchuk-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -w /scripts -v ${PWD}:/scripts -d postgres`

3. Почнемо роботу з оболонкою командного рядку запущеного контейнеру

`docker exec -it tomchuk-postgres bash`

4. Створимо нову БД під користувачем `postgres` та назвою 'berislavskijdb`

`createdb berislavskijdb -U postgres`

5. У базі даних `berislavskijdb` під користувачем `postgres` виконаємо SQL-скрипт для створення та заповнення БД

`psql -U postgres -d berislavskijdb < ./scripts/db_script.sql`

6. Вийдемо із оболонки командного рядку

`exit`

#### Перевірка працездатності

1. Перегляньмо файли у поточному каталозі

`ls`

2. Встановимо змінні оточення `JAVA_HOME` та `PATH`, що будуть вказувати на корень каталогу із JDK 8 версії та його каталог `bin` відповідно. 

`$Env:JAVA_HOME="C:\Users\Admin\.jdks\corretto-1.8.0_342"`
`$Env:PATH="C:\Users\Admin\.jdks\corretto-1.8.0_342\bin"`

3. Скомпілюємо файл із Java-кодом `ProgramClientCode.java`, додатково вказавши драйвер для нашої бази даних 

`javac -cp "postgresql-42.5.0.jar;." ProgramClientCode.java`

4. Виконаємо скомпільований `Main.class` додатково вказавши драйвер для нашої бази даних та параметри `berislavskiydb`, `postgres` - назва БД та пароль до неї

`java -cp "postgresql-42.5.0.jar;." ProgramClientCode berislavskijdb postgres`