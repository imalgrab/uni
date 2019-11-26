#include <iostream>
#include <list>
#include <map>
#include <queue>
#include <vector>

using namespace std;

class Vertex {
   private:
    string name;
    int index;

   public:
    Vertex(string n, int i) {
        name = n;
        index = i;
    }
};

class Graph {
   private:
    int v;
    int idx;
    vector<list<pair<int, int>>> adj;
    map<string, int> verticesNameIdx;
    map<int, string> verticesIdxName;
    bool vertexExists(string v_name) {
        return !(verticesNameIdx.find(v_name) == verticesNameIdx.end());
    }
    bool isValidID(int id) {
        return (id >= 0) && (id <= idx);
    }
    bool edgeExists(int v_id, int d_id) {
        if (!isValidID(v_id) || !isValidID(d_id)) {
            throw new exception();
        }
        for (auto p : adj[v_id]) {
            int did = p.first;
            if (did == d_id) {
                return true;
            }
        }
        return false;
    }

   public:
    Graph(int num_of_v) {
        v = num_of_v;
        idx = 0;
        adj.assign(v, list<pair<int, int>>{});
    }
    void add_edge(int v_id, int d_id, int w) {
        if (isValidID(v_id) && isValidID(d_id)) {
            adj[v_id].push_back({d_id, w});
            adj[d_id].push_back({v_id, w});
        }
    }
    void add_edge(string v_name, string d_name, int w) {
        if (vertexExists(v_name) && vertexExists(d_name)) {
            int v_id = verticesNameIdx[v_name];
            int d_id = verticesNameIdx[d_name];
            adj[v_id].push_back({d_id, w});
            adj[d_id].push_back({v_id, w});
        }
    }
    void change_weight(int v_id, int d_id, int n_w) {
        if (edgeExists(v_id, d_id)) {
            list<pair<int, int>>::iterator i;
            for (i = adj[v_id].begin(); i != adj[v_id].end(); i++) {
                if ((*i).first == d_id) {
                    (*i).second = n_w;
                    break;
                }
            }
        }
    }
    void change_weight(string v_name, string d_name, int n_w) {
        if (vertexExists(v_name) && vertexExists(d_name)) {
            int v_id = verticesNameIdx[v_name];
            int d_id = verticesNameIdx[d_name];
            if (edgeExists(v_id, d_id)) {
                list<pair<int, int>>::iterator i;
                for (i = adj[v_id].begin(); i != adj[v_id].end(); i++) {
                    if ((*i).first == d_id) {
                        (*i).second = n_w;
                        break;
                    }
                }
            }
        }
    }
    void del_edge(int v_id, int d_id) {
        list<pair<int, int>>::iterator i;
        for (i = adj[v_id].begin(); i != adj[v_id].end(); i++) {
            if ((*i).first == d_id) {
                adj[v_id].remove(*i);
                break;
            }
        }
        for (i = adj[d_id].begin(); i != adj[d_id].end(); i++) {
            if ((*i).first == v_id) {
                adj[d_id].remove(*i);
                break;
            }
        }
    }
    void sdel_edge(int v_id, int d_id) {
        if (edgeExists(v_id, d_id)) {
            del_edge(v_id, d_id);
        }
    }
    void sdel_edge(string v_name, string d_name) {
        if (vertexExists(v_name) && vertexExists(d_name)) {
            cout << "Wierzcholki OK\n";
            int v_id = verticesNameIdx[v_name];
            cout << "ID S: " << v_id << "\t";
            int d_id = verticesNameIdx[d_name];
            cout << "ID D: " << d_id << "\n";
            if (edgeExists(v_id, d_id)) {
                del_edge(v_id, d_id);
            }
        }
    }
    void add_vertex(string name) {
        if (vertexExists(name)) {
            throw new invalid_argument("This vertex already exists");
        }
        if (idx >= v) {
            adj.push_back(list<pair<int, int>>{});
            v++;
        }
        verticesNameIdx[name] = idx;
        verticesIdxName[idx] = name;
        idx++;
    }
    void del_vertex(string name) {
        if (verticesNameIdx.find(name) == verticesNameIdx.end()) {
            throw new exception();
        }
        int v_id = verticesNameIdx[name];
        vector<list<pair<int, int>>>::iterator i = adj.begin() + v_id;
        list<pair<int, int>> pairsDestWeight = *i;            //lista sasiadow usuwanego wierzcholka
        adj[v_id].erase(adj[v_id].begin(), adj[v_id].end());  //usun liste sasiadow
        for (auto p : pairsDestWeight) {
            int d_id = p.first;
            del_edge(v_id, d_id);  //usun krawedzie
        }
    }
    void del_vertex(int index) {
        if (index > idx || index < 0) {
            throw new exception();
        }
        vector<list<pair<int, int>>>::iterator i = adj.begin() + index;
        list<pair<int, int>> pairsDestWeight = *i;               //lista sasiadow usuwanego wierzcholka
        adj[index].erase(adj[index].begin(), adj[index].end());  //usun liste sasiadow
        for (auto p : pairsDestWeight) {
            int d_id = p.first;
            del_edge(index, d_id);  //usun krawedzie
        }
    }
    bool pathExists(int v_id, int d_id) {
        if (!isValidID(v_id) || !isValidID(d_id))
            return false;
        if (v_id == d_id)
            return true;
        bool visited[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        queue<int> q;
        visited[v_id] = true;
        q.push(v_id);
        while (!q.empty()) {
            int n_id = q.front();
            q.pop();
            for (auto p : adj[n_id]) {
                n_id = p.first;
                if (!visited[n_id]) {
                    if (n_id == d_id)
                        return true;
                    visited[n_id] = true;
                    q.push(n_id);
                }
            }
        }
        return false;
    }
    bool pathExists(string v_name, string d_name) {
        if (!vertexExists(v_name) || !vertexExists(d_name))
            return false;
        if (v_name == d_name)
            return true;
        bool visited[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
        queue<int> q;
        int v_id = verticesNameIdx[v_name];
        visited[v_id] = true;
        q.push(v_id);
        while (!q.empty()) {
            int n_id = q.front();
            q.pop();
            for (auto p : adj[n_id]) {
                n_id = p.first;
                if (!visited[n_id]) {
                    if (n_id == verticesNameIdx[d_name])
                        return true;
                    visited[n_id] = true;
                    q.push(n_id);
                }
            }
        }
        return false;
    }
    void printNeighbours(string v_name) {
        if (vertexExists(v_name)) {
            int v_id = verticesNameIdx[v_name];
            cout << v_name << " : ";
            for (auto p : adj[v_id]) {
                cout << "{" << verticesIdxName[p.first] << ", " << p.second << "} ";
            }
            cout << "\n";
        }
    }
    void printNeighbours(int v_id) {
        if (isValidID(v_id)) {
            cout << v_id << " : ";
            for (auto p : adj[v_id]) {
                cout << "{" << p.first << ", " << p.second << "} ";
            }
            cout << "\n";
        }
    }
    void print() {
        for (int i = 0; i < adj.size(); i++) {
            cout << verticesIdxName[i] << " : ";
            for (auto pDestWeight : adj[i]) {
                cout << "{" << verticesIdxName[pDestWeight.first] << ", " << pDestWeight.second << "} ";
            }
            cout << "\n";
        }
    }
};

int main() {
    Graph g(2);
    g.add_vertex("a");  //0
    g.add_vertex("b");  //1
    g.add_vertex("c");  //2
    g.add_vertex("x");  //3
    g.add_vertex("y");  //4
    g.add_vertex("z");  //5

    g.add_edge("a", "b", 10);
    g.add_edge(5, 2, 99);  //z->c 99
    g.add_edge("a", "y", 22);
    g.change_weight("a", "y", 33);

    g.printNeighbours("a");
    g.printNeighbours(4);
    g.printNeighbours("c");

    g.del_vertex(1);
    g.del_vertex("c");
    cout << "\n";

    g.printNeighbours("b");
    g.printNeighbours("z");

    cout << g.pathExists(0, 4) << "\n";
    cout << g.pathExists("x", "z");

    return 0;
}