![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


## Zadanie 1 - rozwiązywane z wykładowcą

1. Połącz klasę `Publisher` i `Book` relacją jeden do wielu.
2. Zmodyfikuj kontroler do obsługi książek tak, aby by w metodzie dodawania książki:
- utworzyć i zapisać obiekt `Publisher`,
- połączyć obiekt klasy `Book` z obiektem klasy `Publisher`,
- zapisać obiekt klasy `Book`.

## Zadanie 2

1. Połącz klasę autora i książkę relacją wiele do wielu.
2. Zmodyfikuj kontroler do obsługi książek tak, aby by w metodzie dodawania książki:
- pobrać dwóch dowolnych autorów po ich `id`.
- połączyć obiekt klasy `Book` z pobranymi autorami
- zapisać obiekt klasy `Book`.

## Zadanie 3

1. Utwórz klasę `Person` zawierającą pola:
- id 
- login
- password
- email

2. Utwórz klasę `PersonDetails` zawierającą pola:
- id 
- firstName
- lastName
- streetNumber
- street
- city

3. Połącz encje za pomocą relacji `@OneToOne`.
4. Utwórz kontroler, realizujący operacje CRUD (create, read, update, delete).
