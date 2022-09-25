# RSTTourTestTask
[telegram-cloud-document-2-5280865008593412253.mp4](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/04bb52be-cc5a-484f-969e-dc6d949a2ac9/telegram-cloud-document-2-5280865008593412253.mp4)

Необходимо написать приложение с 2-я экранами:

- главная страница со списком объектов
- экран самого объекта.

При открытии приложения открывается главная страница. Нижняя навигация содержит 5 разделов, реализовывать их не нужно, только "Главная".

При нажатии на объект, должен открыться экран самого объекта с полным описанием, как на видео. Необходимо обрабатывать клик только на экран с `template.object == "blog"`

Запрос на получение объектов главной: 

- [https://rsttur.ru/api/base-app/main?id=117](https://rsttur.ru/api/base-app/main?id=117)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/67bad39a-8b2f-411d-b7da-308f9009b5f3/Untitled.jpeg)
    

Параметры template.card, template.size и template.direction обрабатывать необязательно. Достаточно расположить все элементы в 2 столбца.

В ответе content есть поле `url`, по которому должен делаться запрос на получение информации об объекте.

Запрос для получения информации для экрана объекта: 

- https://rsttur.ru/blog-info?id=117&blog_id=...

Запрос необходимо выполнять только для блогов.

Технологии, которые обязательно должны быть использованы: 

- Kotlin only
- Jetpack Compose
- ViewModel
- Retrofit
- Picasso

Также: должна поддерживаться тёмная тема, путём использования MaterialTheme.colors.

Все прочие моменты на усмотрение разработчика. Функционал поверх описанного может оценивать как плюс.

## Модели для запросов смотреть тут

[https://app.swaggerhub.com/apis-docs/RST-API/BaseApp/1.0.0#/](https://app.swaggerhub.com/apis-docs/RST-API/BaseApp/1.0.0#/)

## Макет

[https://www.figma.com/file/0BL9khIYpmFs2BxfqNUYWe/%D0%91%D0%B0%D0%B7%D0%B0-%D0%BE%D1%82%D0%B4%D1%8B%D1%85%D0%B0-(Android)?node-id=639%3A27547](https://www.figma.com/file/0BL9khIYpmFs2BxfqNUYWe/%D0%91%D0%B0%D0%B7%D0%B0-%D0%BE%D1%82%D0%B4%D1%8B%D1%85%D0%B0-(Android)?node-id=639%3A27547)
