#language: ru
@allGUITests
Функционал: я как пользователь хочу проверить работу сайта Lanit education

  Предыстория: на сайте зарегистрировано два пользователя с разными регистрационными данными.
  см. Тест "Заведение нового пользователя в Lanit education"

#Функция: Для проверки функции авторизации на сайте, выполнить авторизацию на сайте зарегистрированным пользователем
#    тесты 1.1 и 1.2
  @login
  Структура сценария: авторизация зарегистрированного пользователя
    Пусть я открыл браузер и загрузил страницу "<стартовая_страница>"
    И на "главная_страница" я нажал на элемент "кнопка_вызова_формы_авторизации"
    Когда отобразился элемент "окно_авторизации"
    Тогда на "главная_страница" я ввел значение "<login>" в поле "логин"
    И на "главная_страница" я ввел значение "<password>" в поле "пароль"
    И на "главная_страница" я нажал на элемент "кнопка_ввода_данных_пользователя"
    Тогда на "главная_страница" отобразился элемент "пиктограмма_активного_пользователя"
    Пусть на "главная_страница" я нажал на элемент "пиктограмма_активного_пользователя"
    И на "главная_страница" элемент "заголовок_личного_кабинета" отображается "<login>"
    Тогда я нажал на элемент "выход"
    И появилось информационное окно
    Тогда я нажал кнопку "Ок"
    И элемент "пиктограмма_активного_пользователя" не отображается

    Примеры:
      | login     | password    | стартовая_страница        |
      | qwerty    | asd112233   | https://dev.n7lanit.ru/   |

#Функция: Для проверки функционала создания тем на сайте, я в качестве авторизированного пользователя
#  пользователя №1 хочу создать новую тему, но отменить создание
#  тест 2.1
  @cancelTopic
  Структура сценария: выполнение шагов для создания новой темы и отмена создания темы
    Пусть <шаг1>
    И я перешел на страницу "<Темы>"
    Тогда на "<страница_темы>" отобразился элемент "все"
    И на "<страница_темы>" я нажал на элемент "кнопка_создания_новой_темы"
    Тогда на "<страница_темы>" отобразились элементы "заголовок_темы", "сообщение_темы", "кнопка_отмены_публикации"
    Затем на "<страница_темы>" я ввел значение "<Заголовок темы>" в поле "заголовок_темы"
    И на "<страница_темы>" я ввел значение "<Сообщение темы>" в поле "сообщение_темы"
    Затем я нажал на элемент "кнопка_отмены_публикации"
    И я нажал кнопку "Ок"
    Тогда <шаг2>

    Примеры:
      | Заголовок темы|Сообщение темы    |Темы                   | шаг1                                                                            | стартовая_страница | login | password | шаг2                               |
      | NewTopic      |NewTopicDescription |https://dev.n7lanit.ru/| открыть браузер, загрузить "<стартовая_страница>" и авторизоваться с "<login>" и "<password>" | https://dev.n7lanit.ru/ | qwerty| asd112233| выйти из профиля|

#Функция: Для того, чтобы проверить функционал создания тем на сайте, я в качестве зарегистрированного
#  пользователя №1 хочу создать новую тему (заполнить все необходимые поля) и подтвердить создание темы
#    тест 2.2
  @createTopic
  Структура сценария: выполнение шагов для создания новой темы и подтверждение создания темы
    Пусть <шаг1>
    И я перешел на страницу "<Темы>"
    Тогда на "<страница_темы>" отобразился элемент "все"
    И на "<страница_темы>" я нажал на элемент "кнопка_создания_новой_темы"
    Тогда на "<страница_темы>" отобразились элементы "заголовок_темы", "сообщение_темы", "кнопка_публикации_темы"
    Затем на "<страница_темы>" я ввел значение "<Заголовок темы>" в поле "заголовок_темы"
    И на "<страница_темы>" я ввел значение "<Сообщение темы>" в поле "сообщение_темы"
    Затем я нажал на элемент "кнопка_публикации_темы"
    Затем на странице опубликованной темы я нажал на элемент "<Темы>"
    И на "<страница_темы>" отобразился элемент "тема_форума" с текстом "<Заголовок темы>"
    Тогда <шаг2>

#  адрес страницы конкретной темы выглядит как https://dev.n7lanit.ru/t/topic/243/ , где topic - название созданной темы
      Примеры:
      | Заголовок темы|Сообщение темы    |Темы                   | шаг1                                                                            | стартовая_страница | login | password | шаг2                               |
      | NewTopic      |NewTopicDescription |https://dev.n7lanit.ru/| открыть браузер, загрузить "<стартовая_страница>" и авторизоваться с "<login>" и "<password>" | https://dev.n7lanit.ru/ | qwerty| asd112233| выйти из профиля|

##    тест 2.3
#  @myTopicDisplay
#  Функция: я в качестве зарегистрированного пользователя №1 хочу посмотреть, как отображается созданная мной тема
#  Структура сценария: проверка отображения или отсутствия созданной активным пользователем темы в разных вкладках
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Пусть я выполнил "<шаг1>" с "<login>" и "<password>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    И на странице "<Темы>" я нажал на элемент "Все"
#    И на странице "<Темы>" отобразилась тема "<Заголовок темы>" от пользователя "<login>"
#    Затем на странице "<Темы>" нажал на элемент "Мои"
#    И на странице "мои" отобразилась тема "<Заголовок темы>" от пользователя "<login>"
#    Затем на странице "<Темы>" нажал на элемент "Новые"
#    И на странице "новые" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login>"
#    Затем на странице "<Темы>" я нажал на элемент "Непрочитанные"
#    И на странице "непрочитанные" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login>"
#    Затем на странице "<Темы>" я нажал на элемент "Подписки"
#    И на странице "подписки" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                      | login | password | шаг2      |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login>" и "<password>" | qwerty| asd112233| выйти из профиля|

##      тест 2.4
#  @hisTopicDisplay
#  Функция: Для того, чтобы проверить функционал отображения тем на сайте, я в качестве зарегистрированного
#  пользователя №2 хочу посмотреть, как отображается созданная пользователем №1 тема
#  Структура сценария: проверка отображения или отсутствия созданной неактивным пользователем темы в разных вкладках
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Пусть я выполнил "<шаг1>" с "<login2>" и "<password2>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    Затем на странице "<Темы>" я нажал на элемент "Все"
#    И на странице "<Темы>" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "<Темы>" я нажал на элемент "Мои"
#    И на странице "мои" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "<Темы>" я нажал на элемент "Новые"
#    И на странице "новые" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "<Темы>" я нажал на элемент "Непрочитанные"
#    И на странице "непрочитанные" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "<Темы>" я нажал на элемент "Подписки"
#    И на странице "подписки" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                        | login1| login2 | password2|шаг2                               |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login2>" и "<password2>" | qwerty| qwerty1| asd112244|выйти из профиля и закрыть браузер |
#
##      тест 2.5
#  @topicIsNotNew
#  Функция: Для того, чтобы проверить функционал отображения тем на сайте, я в качестве зарегистрированного
#  пользователя №2 хочу проверить, отображается ли созданная пользователем №1 тема во вкладке Новые после того, как я ее уже увидел
#  Структура сценария: проверка отсутствия созданной неактивным пользователем темы во вкладке Новые
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Дано я увидел "<Заголовок темы>" в TestHisTopicIsDisplayed
#    Пусть я выполнил "<шаг1>" с "<login2>" и "<password2>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    Затем на странице "<Темы>" я нажал на элемент "Новые"
#    И на странице "новые" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "новые" я открыл страницу темы "<Заголовок темы>"
#    И на "страница_конкретной_темы" отобразилась страница темы "<Заголовок темы>" с элементом "Ответить"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    И на странице "<Темы>" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "<Темы>" я нажал на элемент "Новые"
#    И на странице "новые" НЕ отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                      | login1| login2 | password2|шаг2                               |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login>" и "<password>" | qwerty| qwerty1| asd112244|выйти из профиля и закрыть браузер |
#
##      тест 2.6
#  @addTopicToUnread
#  Функция: Для того, чтобы проверить отображение непрочитанных тем на сайте, я в качестве зарегистрированного
#  пользователя №2 хочу добавить сообщение к теме, созданной пользователем №1, и проверить, что это сообщение отображается
#  во вкладке Непрочитанные у пользователем №1
#  Структура сценария: добавление сообщения пользователя №2 в теме пользователя №1, проверка сообщения пользователем №1
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Пусть я выполнил "<шаг1>" с "<login2>" и "<password2>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    Затем на странице "<Темы>" я открыл страницу темы "<Заголовок темы>"
#    И на "страница_конкретной_темы" отобразилась страница темы "<Заголовок темы>" с элементом "Ответить"
#    Тогда на "страница_конкретной_темы" я нажал элемент "Ответить", ввел сообщение "<Сообщение>" и нажал элемент "Отправить ответ"
#    И на "страница_конкретной_темы" отобразилось "<Сообщение>" и мой логин "<login2>"
#    Тогда я выполнил "<шаг2>"
#    Пусть я выполнил "<шаг1>" с "<login1>" и "<password1>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    Затем на странице "<Темы>" я нажал на элемент "Непрочитанные"
#    И на странице "непрочитанные" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                      | login1|password1| login2 | password2|шаг2                               | Сообщение   |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login>" и "<password>" | qwerty|asd112233 |qwerty1| asd112244|выйти из профиля и закрыть браузер | Great Topic!|
#
#  #      тест 2.7
#  @topicIsNotUnread
#  Функция: Для того, чтобы проверить отображение непрочитанных тем на сайте, я в качестве зарегистрированного
#  пользователя №1 хочу прочитать сообщение к моей теме, а потом проверить, осталось ли оно во вкладке Непрочитанные
#  Структура сценария: проверка прочтения сообщения к теме, проверка отображения сообщения в Непрочитанных после того,
#  как сообщение прочитано
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Дано добавлено "<Сообщение>" к теме в тесте TestAddTopicToUnread
#    Пусть я выполнил "<шаг1>" с "<login1>" и "<password1>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    Затем на странице "<Темы>" я нажал на элемент "Непрочитанные"
#    И на странице "непрочитанные" отобразилась тема с названием "<Заголовок темы>" от пользователя "<login1>"
#    Затем на странице "непрочитанные" я открыл "страница_конкретной_темы" "<Заголовок темы>"
#    И на "страница_конкретной_темы" отобразилась страница темы "<Заголовок темы>" с элементом "Ответить"
#    И я перешел на страницу "<Темы>"
#    Затем на странице "<Темы>" я нажал на элемент "Непрочитанные"
#    И на странице "непрочитанные" НЕ отобразилась тема с названием "<Заголовок темы>" от пользователя "<login1>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                      | login1|password1 |шаг2                               | Сообщение   |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login>" и "<password>" | qwerty|asd112233 |выйти из профиля и закрыть браузер | Great Topic!|
#
##      тест 2.8
#  @subscribeUnsubscribe
#  Функция: Для того, чтобы проверить подписку на темы на сайте, я в качестве зарегистрированного
#  пользователя №2 хочу подписаться на тему пользователя №1 и отписаться
#  Структура сценария: проверка возможности подписаться на тему неактивного пользователя и отписаться
#    Дано создана новая тема "<Заголовок темы>" в TestCreateNewTopic
#    Пусть я выполнил "<шаг1>" с "<login2>" и "<password2>"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    И на странице "<Темы>" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    Тогда на странице "<Темы>" я нажал на кнопку "Звезда" напротив темы "<Заголовок темы>"
#    И на странице "<Темы>" появился выпадающий список с элементом "Подписаться", я нажал на элемент "Подписаться"
#    И на странице "<Темы>" кнопка "Звезда" напротив темы "<Заголовок темы>" отобразилась как "Активна"
#    Затем на странице "<Темы>" я нажал на элемент "Подписки"
#    И на странице "подписки" отобразилась тема "<Заголовок темы>" от пользователя "<login1>"
#    И на странице "подписки" отобразилась тема "<Заголовок темы>" с признаком "Активна"
#    Тогда на странице "подписки" я нажал на кнопку "Звезда" напротив темы "<Заголовок темы>"
#    И на странице "подписки" появился выпадающий список с элементом "Отписаться", я нажал на элемент "Отписаться"
#    И на странице "подписки" отобразилась тема "<Заголовок темы>" с признаком "Неактивна"
#    И я перешел на страницу "<Темы>"
#    Тогда на странице "<Темы>" отобразился элемент "Все", по умолчанию открыта вкладка "Все"
#    И на странице "<Темы>" отобразилась тема "<Заголовок темы>" с признаком "Неактивна"
#    Затем на странице "<Темы>" я нажал на элемент "Подписки"
#    И на странице "подписки" НЕ отобразилась тема с названием "<Заголовок темы>" от пользователя "<login1>"
#    Тогда я выполнил "<шаг2>"
#
#    Примеры:
#      | Заголовок темы| Темы                    | шаг1                                                                                      | login2 | password2|шаг2                               |
#      | NewTopic      | https://dev.n7lanit.ru/ | открыть браузер, загрузить "главная_страницв" и авторизоваться с "<login>" и "<password>" |qwerty1 | asd112244|выйти из профиля и закрыть браузер |
