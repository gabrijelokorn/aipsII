Imamo neurejeno množico števil T, ki jo želimo urediti po velikosti.

Algoritem heapsort, nam bom omogočil, da to množico uredimo v času **O(n log n)**, kjer je n število elementov.

**Postopek heapsort**:
- najprej implementirajte metodo za pogrezanje, ki delno pokvarjeno kopico popravi
- nato implementirajte metodo, ki iz poljubne tabele zgradi veljavno kopico *(seveda z uporabo metode razvite v predhodni točki)*
- nazadnje uporabite prej definirani metodi za ureditev poljubne tabele s kopico