# JavaHtmlTextInterpreter
Приложение Java, которое принимает адрес веб-страницы, разбивает весь текст на ней на отдельные слова и отображает статистику использования каждого слова.
Слово может содержать дефис или апостроф. Цифры, знаки препинания и специальные символы не считаются словами.

#### Использование приложения
- В запущенном приложении ввести адрес требуемой страницы (например, microsoft.com). Поддерживаются только протоколы http и https. Указывать протокол не обязательно, при отсутствии он добавляется автоматически.
- Если ссылка корректна и если веб-страница содержит текстовые данные, будут выведены все имеющиеся на ней слова и частота использования каждого из них.

#### Запуск приложения
- Скачать jar-файл из /out/artifacts/JavaHtmlTextInterpreter_jar
- Запустить jar-файл консольной командой java -jar JavaHtmlTextInterpreter.jar

Логи приложения появляются в каталоге <каталог_с_jar_файлом>/logs.

Проект использует Maven. Для запуска проекта необходимо открыть папку с ним в среде разработки (например, IntelliJ IDEA)

# JavaHtmlTextInterpreter
Java app gets a web page by the given address, parses all text data on the page to separate words and displays the statistics for each word's usage.
The word may contain hyphen or apostrophe. Digits, punctuation marks and special symbols don't count as words.

#### Using the app
- Launch the app and enter address of the required HTML page (e.g. microsoft.com). Only http and https protocols are supported. It isn't necessary to specify the protocol, it'll be added automatically if missing.
- If the URL is correct, and the web page contains text data, all existing words on the page will be displayed along with usage frequency for each of them. 

#### Launching the app
- Download the jar file from /out/artifacts/JavaHtmlTextInterpreter_jar
- Launch the jar file through console command java -jar JavaHtmlTextInterpreter.jar

The application logs appear at <jar_file_directory>/logs.

This project uses Maven. To launch the project, open the project folder in the IDE (e.g. IntelliJ IDEA)
