Imamo dve števili a in b, ki ji ju želimo zmnožiti z aloritmom, ki to reši s časovno zahtevnostjo boljšo od O(n^2).

Uporabimo "Karatsubov" algoritem z rekurzivno metodo:

```
static int karatsuba (int a, int b) {
    if (a < B || b < B) {
        return a * b;
    } else {
        int n = size(a) <= size(b) ? size(a) : size(b);
        int m = n / 2;
        int aL = a / (int) Math.pow(10, m);
        int aD = a % (int) Math.pow(10, m);
        int bL = b / (int) Math.pow(10, m);
        int bD = b % (int) Math.pow(10, m);

        int z0 = karatsuba(aD, bD);
        int z2 = karatsuba(aL, bL);
        int z1 = karatsuba(aL + aD, bL + bD) - z2 - z0;
        
        return (((int) (Math.pow(10, 2 * m) * z2)) + ((int) (Math.pow(10, m) * z1))) + z0;
    }
}
```

Časovna zahtevnost tega algoritma je **Θ(n*log2 (3) )**.