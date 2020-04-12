# Read Me First
НЛМК Заглушка ИС Транспорт
* SPRINGBOOT
* WEB MVC
* LOMBOK
* ASPECTJ

# RUN Application
java -jar nlmk.jar

# Getting Started
Все файлы-заглушки называются так же как и потоки. Разделитель во всех файла ",".
        Первая строчка содержит наименование колонок.

### Поток №1 RoadAvailability
url: GET: /road-availability/mock
Порядок заполнения

* roadCode
* roadName
* roadAvailable

### Поток №2 PreBooking
url: GET: /prebooking/mock
Порядок заполнения:

* date
* shift
* carriageType
* carriageAmount
* holderType
* holderAmount


### Поток №3 CarriageAvailability
url: GET: /carriage-availability/mock
Порядок заполнения:
* carriageId
* carriageType
* carriageCapacity
* wearout
* date

### Поток №4 HolderAvailability
url: GET: /holder-availability/mock
Порядок заполнения:
* holderType
* holderAmount
* workshopCode
* date

### Поток 5. Отправка заявки на ПС на смену (бронирование)
url: POST: /carriage-booking/mock
* Request
[{
"date": "2000-10-31T01:30:00.000-05:00",
"shift": "1",
"deadEnd": "28Г",
"orderId": "1",
"totalWeight": "1.5",
"carriageId": "1",
"workshopCode": "5"
}]

### Поток 6. Отправка заявки на крепления на смену (бронирование)
url: POST: /holder-booking/mock
* Request
[{
"workshopCode": "1",
"date": "2000-10-31T01:30:00.000-05:00",
"shift": "1",
"deadEnd": "29",
"holderType": "FLAT ROCK BO",
"holderAmount": "11"
}]

### Поток №7. CarriagesSent. Получение данных по фактически отправленным в цех ПС
url: GET: /carriage-sent/mock
Порядок заполнения:
* date
* shift
* deadEnd
* carriageId
* carriageType
* carriageCapacity
* carriageCondition
* carriagePurpose