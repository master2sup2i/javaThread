#include <stdio.h>
#include <stdib.h>

int main()
{

int A,B;
float C;

puts ("valeur de A:");
scanf("%d",&A);

puts ("valeur de B:");
scanf("%d",&B);

puts ("valeur de C:");
scanf("%C", &C);

double r;
r = calcul(A,B,C);

printf("Résultat : %d\n",r);

return 0;
} 