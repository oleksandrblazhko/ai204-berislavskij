|FR id|TC id|Опис кроків тестового сценарію|Опис очікуваних результатів|
|:-:|:-:|:-|:-:|
|FR1.4|TC1.1|Початкові умови: нерозглянуте бронювання з bookingId = 23 наявне в базі <br> Кроки сценарію: <br> 1)bookingId = 23  <br> 2) status = "Accepted"<br>|Результат =  200|
|FR1.4|TC1.2|Початкові умови: в базі відсутні бронювання з bookingId = 23 <br> Кроки сценарію: <br> 1) bookingId = 23 <br> 2) status = "Accepted"<br>|Результат = EntityNotFoundException|
|FR1.4|TC1.3|Початкові умови: бронювання з bookingId = 23 вже було розглянуто <br> Кроки сценарію: <br> 1) bookingId = 23 <br> 2) status = "Accepted"<br>|ModificationForbiddenException|
|FR1.4|TC1.4|Початкові умови: нерозглянуте бронювання з bookingId = 23 наявне в базі <br> Кроки сценарію: <br> 1) bookingId = 23 <br> 2) status = "Pending"<br>|ImproperStatusException|