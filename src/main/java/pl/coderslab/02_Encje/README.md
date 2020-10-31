![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)


## Zadanie 1 - rozwiązywane z wykładowcą

1. W projekcie `Spring01hibernate` utwórz encje o nazwie `Book`.
2. Ustal nazwę tabeli bazy danych dla tej encji na `books`.
3. Encja ma zawierać następujące pola:
- id 
- title (String)
- rating (int)
- description (String)
4. Uruchom aplikację, a następnie sprawdź, czy w bazie danych pojawiła się tabela.

## Zadanie 2

1. Na podstawie przykładu z prezentacji utwórz klasę `BookDao`.
2. Klasa ma realizować podstawowe operacje na encji:
- zapis encji
- edycja encji
- pobieranie po id
- usuwanie po id

## Zadanie 3

1. Utwórz kontroler o nazwie `BookController`.
2. Utwórz akcje kontrolera, które będą wykonywać następujące operacje:
- zapis encji
- edycja encji
- pobieranie
- usuwanie

3. Wszystkie dane potrzebne do wykonania operacji mogą być zaszyte w kodzie akcji.

## Zadanie 4

1. Utwórz encje o nazwie `Author`.
2. Ustal nazwę tabeli bazy danych dla tej encji na `authors`.
3. Encja ma zawierać następujące pola:
- id 
- firstName
- lastName

4. Utwórz klasę `AuthorDao` - służącą do operacji na tej encji.
5. Utwórz kontroler, realizujący operacje CRUD (create, read, update, delete).

## Zadanie 5

1. Utwórz encje o nazwie `Publisher`.
2. Ustal nazwę tabeli bazy danych dla tej encji na `publishers`.
3. Encja ma zawierać następujące pola:
- id 
- name

4. Utwórz klasę `PublisherDao` - służącą do operacji na tej encji.
5. Utwórz kontroler, realizujący operacje CRUD (create, read, update, delete).
