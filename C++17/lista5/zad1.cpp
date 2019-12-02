#include <cctype>
#include <cstring>
#include <iostream>
#include <list>
#include <queue>
#include <stack>

using namespace std;

struct bracket_mismatch : public exception {
    const char* what() const throw() {
        return "brackets mismatch";
    }
};

bool isoperatororbracket(char x) {
    return (x == '+' || x == '-' || x == '/' || x == '*' || x == '(' || x == ')');
}

list<string> to_list(string exp) {
    list<string> res;
    string num = "";
    for (auto c : exp) {
        if (isdigit(c)) {
            num += c;
        } else if (isoperatororbracket(c)) {
            if (num.length()) {
                res.push_back(num);
                num = "";
            }
            res.push_back(string(1, c));
        }
    }
    if (num.length()) {
        res.push_back(num);
        num = "";
    }
    return res;
}

int get_precendence(string c) {
    if (c == "*" || c == "/")
        return 2;
    if (c == "+" || c == "-" || c == ")")
        return 1;
    return 0;
}

bool isoperator(string c) {
    return (c == "+" || c == "-" || c == "*" || c == "/");
}

bool islbracket(string c) {
    return c == "(";
}

bool isrbracket(string c) {
    return c == ")";
}

bool isdigit(string c) {
    if (c.length() > 0) {
        for (int i = 0; i < c.length(); i++) {
            if (!isdigit(c[i]))
                return false;
        }
        return true;
    }
    return false;
}

list<string> convert_to_rpn(string exp) {
    list<string> lexp = to_list(exp);
    queue<string> q;
    stack<string> s;
    list<string>::iterator i;
    list<string> conv_exp;
    bool was_lbracket = false;
    for (i = lexp.begin(); i != lexp.end(); i++) {
        string curr_char = *i;
        if (isdigit(curr_char)) {
            q.push(curr_char);
            q.push(" ");
        }
        if (isoperator(curr_char)) {
            if (!s.empty()) {
                string s_top = s.top();
                while (isoperator(s_top) && (get_precendence(s_top) >= get_precendence(curr_char))) {
                    q.push(s_top);
                    s.pop();
                    if (s.empty())
                        break;
                    s_top = s.top();
                }
            }
            s.push(curr_char);
        }
        if (islbracket(curr_char)) {
            was_lbracket = true;
            s.push(curr_char);
        }
        if (isrbracket(curr_char)) {
            if (!was_lbracket) {
                throw new bracket_mismatch();
            }
            was_lbracket = false;
            string s_top = s.top();
            while (!islbracket(s_top)) {
                q.push(s_top);
                s.pop();
                s_top = s.top();
            }
            s.pop();
        }
    }
    if (was_lbracket) {
        throw new bracket_mismatch();
    }
    while (!s.empty()) {
        string s_top = s.top();
        q.push(s_top);
        s.pop();
    }
    while (!q.empty()) {
        string q_top = q.front();
        conv_exp.push_back(q_top);
        q.pop();
    }
    return conv_exp;
}

int main() {
    string exp = "2*(3+7)-11";
    list<string> conv_exp = convert_to_rpn(exp);
    for (auto lex : conv_exp) {
        cout << lex;
    }
    cout << "\n";
    return 0;
}
