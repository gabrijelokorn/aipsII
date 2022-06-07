Imamo neurejeno množico števil T, ki jo želimo urediti po velikosti.

Algoritem quicksort, nam bom omogočil, da to množico uredimo v času O(log n), kjer je n število elementov.

**Postopek quicksort**:
- določimo pivot *(prvi element/ zadnji element / srednji element / povrpečje prvega in zadnjega)*
- množico začnemo urejati na dva dela:
    - sprehajamo se po množici z eno spremenljiko od leve proti desni in z drugo spremenljivko od desne proti levi, dokler z leve ne naletimo do večjega elementa od pivota in z desno manjšega elementa od pivota
    - tedaj zamenjamo elementa na teh dveh indeksih
    - ponavaljamo ta dva koraka dokler je indeks leve spremenljivke večji od desne spremenljivke
- ko to polje števil uredimo tabelo razdelimo na dve tabeli, prvo s števili levo od pivota in drugo s števili desno od pivota, na katerih spet ponovimo enak postopek
