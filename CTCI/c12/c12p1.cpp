#include <cstdio>

int main() {
    
    //wrong code:
    // unsigned int i;
    // for (i=100; i >= 0; --i) // (1): it will loop forever (doesnt compile)
    //     printf("%d\n", i);   // (2): %d

    //corrected code:
    unsigned int i;
    for (i=100; i > 0; --i)
        printf("%u\n", i);
}