#language:ru
@all

Функционал:

  Сценарий:

    * Перейдите на сервис "https://www.ozon.ru"
    * Выполните поиск по "iphone"
    * Ограничить цену до "100000"
    * Отметить чекбокс – "Высокий рейтинг"
    * Отметить чекбокс – "NFC"
    * Из результатов поиска добавьте в корзину первые 8 нечетных товаров
#    #если нет кнопки добавить, то добавляем следующий четный товар и так до тех пор,
#    #пока не получится всего 8 добавленных.
#    * Запомнить название товаров
    * Перейдите в корзину
    * Убедитесь, что все добавленные ранее товары находятся в корзине
    * Проверить, что отображается текст "Ваша корзина" - "8 товаров"
    * Удалите все товары из корзины
    * Проверьте, что корзина не содержит никаких товаров
##    # В аллюр отчет добавить шаг, в котором будет приложен файл с информацией о всех добавленных товарах
##    #(наименование и цена). Также указать товар с наибольшей ценой.
##

  Сценарий:

    * Перейдите на сервис "http://www.ozon.ru/"
    * Выполните поиск по "беспроводные наушники"
    * Ограничить цену до "10000"
    * Бренды : "Beats", "Samsung", "Xiaomi"
    * Отметить чекбокс – "Высокий рейтинг"
    * Из результатов поиска добавьте в корзину все четные товары
    * Перейдите в корзину
    * Убедитесь, что все добавленные ранее товары находятся в корзине
    * Удалите все товары из корзины
    * Проверьте, что корзина не содержит никаких товаров
#    # В аллюр отчет добавить шаг, в котором будет приложен файл с информацией о всех добавленных товарах
#    # (наименование и цена). Также указать товар с наибольшей ценой.
