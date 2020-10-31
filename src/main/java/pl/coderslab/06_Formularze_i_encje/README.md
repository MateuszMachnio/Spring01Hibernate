![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


## Zadanie 1 - rozwiązywane z wykładowcą

1. W projekcie `Spring01hibernate` utwórz kontroler `BookFormController`, 
umieścimy w nim akcje odpowiedzialne za operacje na obiektach typu `Book` z wykorzystaniem formularzy.
2. Utwórz formularz, który pozwoli dodać obiekt klasy `Book`.
3. Utwórz akcję wyświetlającą formularz.
4. Dodaj akcję obsługującą dane z formularza,
5. Dodaj możliwość wyboru wydawcy z listy rozwijalnej.
6. Zapisz obiekt do bazy danych.

## Zadanie 2 - rozwiązywane z wykładowcą

1. Dodaj akcję wyświetlającą listę wszystkich książek.
2. Skorzystaj z utworzonej wcześniej metody klasy `BookDao` wykorzystującą zapytanie JPQL.
3. Zmodyfikuj akcję zapisu książki dodając przekierowanie do listy książek.   

## Zadanie 3

1. Rozbuduj listę dodając linki umożliwiające przejście do edycji danych oraz usuwania danych.
2. Dodaj formularz edycji danych, zwróć uwagę na poprawne wypełnienie danych podczas edycji.
3. Dodaj akcję usuwania książki.
4. Dodaj zabezpieczenie przed przypadkowym usunięciem danych - 
dodatkową stronę na której wyświetlisz 2 linki: Potwierdź oraz Anuluj.


## Zadanie 4

1. Rozbuduj formularz o możliwość dodania autorów z listy rozwijalnej select.
2. Dodaj konwerter dla encji `Author`.

## Zadanie 5

1. Utwórz kontroler `AuthorController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich autorów
- dodać autora
- usunąć autora
- edytować autora

2. Dla akcji dodawania oraz edycji utwórz formularz.
3. Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.

## Zadanie 6

1. Utwórz kontroler `PublisherController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich wydawców
- dodać wydawcę
- usunąć wydawcę
- edytować wydawcę

2. Dla akcji dodawania oraz edycji utwórz formularz.
3. Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.
