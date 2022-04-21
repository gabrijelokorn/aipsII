Imamo neurejeno množico števil T, ki jo želimo urediti po velikosti.

Algoritem mergesort, nam bom omogočil, da to množico uredimo v času **O(n * log2 (n))**, kjer je n število elementov.

**Postopek mergesort**:

- neurenjo polje števil rekurzivno razdelimo na polovice, ustavimo se, ko je polje dolžine 1
- manjša polja nato združujemo nazaj v večja, pri čemer jih že uredimo:
    - primerjamo števila iz levega in desnega polja pri čemer manjše število vstavimo v končno polje
    - ko v enem izmed polj pridemo do konca, iz drugega lahko števila do konca polja le še pripišemo, kar nam omogoči, da nam ni potrebno primerjati vsakega števila z vsakim
- dobimo urejeno polje

Algoritem mergesort z vidika časovne zahtevnosti dobro razvrsti števila, a **je lahko prostorsko zelo zahteven algoritem**.