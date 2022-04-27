# allegro-summer-experiance-2022
Mobilna aplikacja wyświetlająca listę repozytoriów i liczbę bajtów napisanych w użytych językach dla danego użytkownika.

# Jak uruchomić:

//TODO 

# Założenia:

Aplikacja zakłada, że użytkownik posiada wersję systemu android nie starszą niż 7.0 (API 24)
Wersja ta jest zainstalowana na około 89% urządzeń z sytemem Android, co powinno zagwarantować poprawne działanie na praktycznie wszystkich używanych urządzeniach.
Do projektu zostało użyte JDK 11 jako, że przed wyjściem stosunkowo jeszcze nowego JDK 17, był to najnowszy LTS, na którym to zbudowana jest bardzo duża część aplikacji.


# Pomysły na dalszy rozwój aplikacji: 

Podczas rozwoju projektu wpdłem na kilka pomysłów jak możnaby go dalej rozbudować, a o to kilka z nich:
-dodanbie opisów i dat utworzenia repozytoriów
-dodanie zdjęcia profilowego przeglądanego użytkownika do paska
-autoryzacja użytkownika w celu możliwości przeglądania prywatnych repozytoriów udostępnionych do wglądu danemu użytkownikowi
-dodanie kolorków odpowiadających każdemu językowi tak jak na platformie Github, by uczynić aplikację atrakcyjniejszą wizualnie
-dodanie możliwości przeniesienia na stronę github, by móc dogłębnie przejrzeć dane repozytorium

# Problemy napotkane przy tworzeniu projektu:

Częścią życia programisty jest borykanie się z błędami i nie powinno się wstydzić o tym mówić. Wszystkie problemy udało mi się rozwiązać stosunkowo szybko, jednak sen z powiek spędzał mi brak możliwości używania biblioteki java.net.http.

Owa biblioteka została dodana w 11 wersji Javy, co nie powinno stanowić problemu, gdyż takiej właśnie wersji używałem w projekcie. Na pewno też nie używałem wersji przed 10, gdyż "var", któtre zostało dodane w owej wersji działało poprawnie. Po licznych próobach naprawy importu poprzez reinstalację javy, grzebania w konfiguracji projektu i próbowaana innych wersji JDK, gradle oraz API ostatecznie poradziłem sobie z problemem poprzez napisanie http requesta w stary sposób, sprzed ddodania omawianej biblioteki. Podejrzewam, że problemem było JDK, jednak jeszcze nie udało mi się tego ustalić, a czasu brak. Jest to główny powód z którego wynika moje opóźnienie, za co najmocniej przepraszam.

