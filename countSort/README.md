Imamo neurejeno množico števil T, ki jo želimo urediti po velikosti.

Algoritem countsort, nam bom omogočil, da to množico uredimo v času **O(n + k)**, kjer je n število elementov in k razpon vrednosti za elemente n.

**Postopek countsort**:

- ustvarimo polje **c**, velikosti **k**, v takterga pišemo število elementov z lastnostjo s pripadajočim indeksom
- sprehodimo se po polju **c** in vsakemu indeksu prištejemo število vseh števil do tega indeksa
- naredimo končno polje **R**, v katera pišemo končno urejeno tabelo
- sprehodimo se po polju **T** od zadnjega elementa proti prvemu in indeks te vrednosti najdemo v **c**, ta vrednost pri indeksu v **c** nam pove končno pozicijo v **R**, s tem da sedaj popravimo novo stanje v **c**

Ta algoritem je časovno zelo dober, a je lahko pomnilniško zahteven.
