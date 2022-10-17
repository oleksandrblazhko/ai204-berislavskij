### Прототипи методів програмних класів

<table>
    <thead align="center">
        <tr>
            <td>FR</td>
            <td>Опис функціональної вимоги</td>
            <td>Назва класу</td>
            <td>Назва методу класу</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td align="center">FR1</td>
            <td>Розглянути заявку організатора</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td align="center">FR1.1</td>
            <td>Система повинна надіслати повідомлення орендатору про наявність заявки на оренду місця проведення</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tr>
            <td align="center">FR1.2</td>
            <td>Орендатор може переглядати заявки на оренду, впорядковані за датою проведення</td>
            <td>User</td>
            <td>getBookings()</td>
        </tr>
        <tr>
            <td align="center">FR1.3</td>
            <td>Орендатор може переглянути інформацію про запланований захід з заявки організатора</td>
            <td>Booking</td>
            <td>getEvent()</td>
        </tr>
        <tr>
            <td align="center">FR1.4</td>
            <td>Орендатор може відхилити чи прийняти заявку</td>
            <td>User</td>
            <td>reply(Booking, StatusEnam)</td>
        </tr>
        <tr>
            <td align="center">FR1.5</td>
            <td>Орендатор отримує плату за оренду місця проведення</td>
            <td>User</td>
            <td>topUp(Double)</td>
        </tr>
        <tr>
            <td align="center">FR2</td>
            <td>Обрання приміщення з оптимальним рівнем шуму</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td align="center">FR2.1</td>
            <td>Організатор може переглядати список вільних місць для проведення заходу за певними параметрами</td>
            <td>Appartment</td>
            <td>getAvailable()</td>
        </tr>
        <tr>
            <td align="center">FR2.2</td>
            <td>Організатор може переглянути детальну інформацію про запропоноване місце проведення зі списку</td>
            <td>Appartment</td>
            <td>Getters</td>
        </tr>
        <tr>
            <td align="center">FR2.3</td>
            <td>Організатор може надіслати запит до системи розумного будинку для отримання показників шуму</td>
            <td>NoiseMeter</td>
            <td>getNoiseInfo()</td>
        </tr>
        <tr>
            <td align="center">FR2.4</td>
            <td>Організатор може надіслати заявку на оренду приміщення</td>
            <td>User</td>
            <td>sendRequest()</td>
        </tr>
        <tr>
            <td align="center">FR2.5</td>
            <td>Організатор проводить сплату після розглянення заявки з боку арендатора</td>
            <td>User</td>
            <td>MakeTransaction()</td>
        </tr>
    </tbody>
</table>
