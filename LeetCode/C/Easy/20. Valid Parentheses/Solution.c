bool isValid(char* s) {
    #define MAX 100000
    int top=-1;
    char stack[MAX];
    // void push(char ch)
    // {
    //     stack[++top]=ch;
    // }
    // char pop()
    // {
    //     return stack[top--];
    // }
    // bool isEmpty()
    // {
    //     return top==-1;
    // }

    int len=strlen(s);
    for(int i=0;i<len;i++)
    {
        if(s[i]=='[' || s[i]=='{' || s[i]=='(')
        {
            stack[++top]=s[i];
        }
        else
        {
            if(top==-1)   return false;
            else
            {
                char ch=stack[top--];
                if( (ch=='[' && s[i]==']')||
                    (ch=='{' && s[i]=='}')||
                    (ch=='(' && s[i]==')') )
                    {

                    }
                else
                {
                    return false;
                }
            }
        }
    }
    return (top==-1);
}