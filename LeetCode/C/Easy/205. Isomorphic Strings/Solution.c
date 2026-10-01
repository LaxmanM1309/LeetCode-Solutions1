bool isIsomorphic(char* s, char* t) {

    if(strlen(s) != strlen(t))  return false;

    int map1[256] = {0}; // Maps s[i] to t[i]
    int map2[256] = {0}; // Maps t[i] to s[i]

    for (int i = 0; i < strlen(s); i++) {
        char c1 = s[i];
        char c2 = t[i];

        if (map1[c1] == 0 && map2[c2] == 0) {
            map1[c1] = c2;
            map2[c2] = c1;
        } else {
            if (map1[c1] != c2 || map2[c2] != c1)
                return false; // Not isomorphic
        }
    }

    return true;
    

    
}