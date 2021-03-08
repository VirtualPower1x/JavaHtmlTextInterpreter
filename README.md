# JavaHtmlTextInterpreter
Приложение Java, которое принимает ссылку на HTML-страницу, разбивает весь текст на ней на отдельные слова и отображает статистику использования каждого слова.
Слово может содержать дефис или апостроф. Цифры, знаки препинания и специальные символы не считаются словами.

Использование приложения:
- В запущенном приложении ввести адрес требуемой страницы (например, https://microsoft.com). Адрес должен обязательно начинаться с http:// или https://, вводить www. не обязательно.
- Если ссылка корректна и если веб-страница содержит текстовые данные, будут выведены все имеющиеся на ней слова и частота использования каждого из них.

Для запуска приложения:
- Скачать jar-файл из /out/artifacts/JavaHtmlTextInterpreter_jar
- Запустить jar-файл консольной командой java -jar JavaHtmlTextInterpreter.jar

Проект использует Maven. Для запуска проекта необходимо открыть папку с ним в среде разработки (например, IntelliJ IDEA)

Java app that gets HTML page from the URL entered in, parses all text data on the page to separate words and displays the statistics for each word's usage.
The word may contain hyphen or apostrophe. Digits, punctuation marks and special symbols don't count as words.

Using the app:
- Launch the app and enter address of the required HTML page (e.g. https://microsoft.com). The address must start with http:// or https://. It isn't neccessary to type www.
- If the URL is correct and the web page contains text data, all existing words on the page will be displayed along with usage frequence for each of them. 

For launching the app:
- Download the jar file from /out/artifacts/JavaHtmlTextInterpreter_jar
- Launch the jar file through console command java -jar JavaHtmlTextInterpreter.jar

This project uses Maven. To launch the project, open the project folder in the IDE (e.g. IntelliJ IDEA)
