### Словник атрибутів об’єктів

<table>
    <thead align="center">
        <tr>
            <td>Об'єкт</td>
            <td>Атрибут</td>
            <td>Короткий опис</td>
            <td>Тип</td>
            <td>Обмеження</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Authority</td>
            <td>Name</td>
            <td>Назва повноваження</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>Role</td>
            <td>Name</td>
            <td>Назва ролі</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td rowspan="2">Subscription</td>
            <td>Name</td>
            <td>Назва підписки</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>Ціна підписки</td>
            <td>Числовий</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="5">User</td>
            <td>role</td>
            <td>Назва ролі користувача</td>
            <td>role</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>name</td>
            <td>Ім'я користувача</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>surname</td>
            <td>Прізвище користувача</td>
            <td>текст</td>
            <td></td>
        </tr>
        <tr>
            <td>balance</td>
            <td>Кількість грошових коштів на рахунку користувача</td>
            <td>Числовий</td>
            <td></td>
        </tr>
        <tr>
            <td>subscription</td>
            <td>Підписка, придбана користувачем</td>
            <td>Subscription</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="5">Appartment</td>
            <td>Address</td>
            <td>Адреса</td>
            <td>Текст</td>
            <td>Щонайменше 5 символів</td>
        </tr>
        <tr>
            <td>Owner</td>
            <td>Власник</td>
            <td>User</td>
            <td>not null</td>
        </tr>
        <tr>
            <td>Max people</td>
            <td>Максимальна кількість людей, що можуть розташуватися</td>
            <td>Числовий</td>
            <td></td>
        </tr>
        <tr>
            <td>Price</td>
            <td>Ціна оренди за годину</td>
            <td>Числовий</td>
            <td></td>
        </tr>
        <tr>
            <td>Size</td>
            <td>Розмір у квадратних метрах</td>
            <td>Числовий</td>
            <td>Більше нуля</td>
        </tr>
        <tr>
            <td rowspan="4">Бронювання</td>
            <td>User</td>
            <td>Користувач, що щробив замовлення</td>
            <td>User</td>
            <td>Not null</td>
        </tr>
        <tr>
            <td>Appartment</td>
            <td>Приміщення, що орендується</td>
            <td>Appartment</td>
            <td>Not null</td>
        </tr>
        <tr>
            <td>TimeStamp</td>
            <td>Проміжок часу, на який проводиться оренда</td>
            <td>Час</td>
            <td>більше нуля</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>Статус бронювання оренди риміщення</td>
            <td>текст</td>
            <td>not null</td>
        </tr>
        <tr>
            <td>NoiseMeter</td>
            <td>Name</td>
            <td>Назва вимірювача</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
</table>
