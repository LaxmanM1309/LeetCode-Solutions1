char* intToRoman(int num) {
    int values[] =    {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9,   5,  4,  1};
    char* symbols[] = {"M",  "CM", "D", "CD","C", "XC","L","XL","X","IX","V","IV","I"};
    int len=sizeof(values)/sizeof(values[0]);

    char * result= (char *) malloc (100*sizeof(char));
    result[0]='\0';

    for(int i=0;i<len;i++)
    {
        while(num>=values[i])
        {
            strcat(result,symbols[i]);
            num-=values[i];
        }
    }

    return result;
}