*Koda se od bfprt algoritma malenkost razlikuje (v razdelejevanju tabele t)!*

Po naslednjem načinu, bomo pivot **p** izračunali po korakih:

    1) Tabelo t razdelimo v peterke (tabele po pet zaporednih elementov)
    2) V vsaki peterki poiščemo njeno mediano (tretji najmanjši element)
    3) Naj bo M tabelo vseh dobljenih median.
    4) Potem naj bo p mediana elementov tabele M

Sedaj p uporabimo v proceduri, ki razdeli tabelo t v tabele t1, t2 in t3. Po tako porazdelejeni tabeli t velja |t1| <= 3/4|t| in |t3| <= 3/4|t| in to je le naslabši primer, saj je eden od elementov v t2 in tako ostanejo le še 4. Problem sedaj rešujemo v eni od podnalog rekurzivno.

Časovna zahtevnost tega algoritma je **Θ(n)**, kar je asimptotično optimalno.