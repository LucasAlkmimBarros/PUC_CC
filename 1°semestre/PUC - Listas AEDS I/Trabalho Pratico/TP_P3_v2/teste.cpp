#include <iostream>
#include <string>
using namespace std;

const int NALUNO = 100;

class Data{
    private:
        int dia;
        int mes;
        int ano;
    public:
        Data();
        Data(int d, int m, int a);
        ~Data();
        void setDia(int d);
        void setMes(int m);
        void setAno(int a);
        void setData(int d, int m, int a);
        int getDia();
        int getMes();
        int getAno();
        void leiaData();
        void imprimeData();
        bool verificaData(int d, int m, int a);
};

Data::Data(){
    dia = 0;
    mes = 0;
    ano = 0;
}
Data::Data(int d, int m, int a){
    dia = d;
    mes = m;
    ano = a;
}
Data::~Data(){
    cout << "Data destruida!" << endl;
}
void Data::setDia(int d){
    dia = d;
}
void Data::setMes(int m){
    mes = m;
}
void Data::setAno(int a){
    ano = a;
}
void Data::setData(int d, int m, int a){
    setDia(d);
    setMes(m);
    setAno(a);
}
int Data::getDia(){
    return dia;
}
int Data::getMes(){
    return mes;
}
int Data::getAno(){

    return ano;
}
void Data::leiaData(){
    int d, m, a;
    bool erro;
    do
    {
        cout << "Digite o dia: ";
        cin >> d;
        cout << "Digite o mes: ";
        cin >> m;
        cout << "Digite o ano: ";
        cin >> a;

        if (!verificaData(d, m, a))
        {
            erro = true;
            cout << "\aDATA INVALIDA!" << endl;
            cout << "Digite novamente!" << endl;
        }
        else
        {
            erro = false;
        }
    } while (erro);

    setData(d, m, a);
}
void Data::imprimeData(){
    cout << "\nData: "<< dia << "/" << mes << "/" << ano << endl;
}
bool Data::verificaData(int d, int m, int a){
    bool ehValida = true;
    if (a < 0)
        ehValida = false;
        else if (m < 1 || m > 12) 
            ehValida = false;
            else
            { 
                int qtDiasMes;
                 switch (m)
                {
                    case 2:
                    if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0)
                    {
                       qtDiasMes = 29;
                    }
                    else
                    {
                        qtDiasMes = 28;
                    }
                    break;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        qtDiasMes = 30;
                        break;

                    default:
                        qtDiasMes = 31;
                        break;
                }

                if (d < 1 || d > qtDiasMes)
                    ehValida = false;
            }

    return ehValida;
}



class Aluno{
    private:
        string nome;
        Data dataNascimento;
    public:
        static int quantAlunos;
        Aluno();
        Aluno(string n, int d, int m, int a);
        ~Aluno();
        void setNome(string n);
        string getNome();
        void leiaNome();
        void leiaAluno();
        void imprimeNome();
        void imprimeAluno();
};
int Aluno::quantAlunos = 0;
Aluno::Aluno(){
    nome = "";
    quantAlunos++;
}
Aluno::Aluno(string n, int d, int m, int a){
    nome = n;
    dataNascimento.setData(d, m, a);
    quantAlunos++;
}
Aluno::~Aluno(){
    cout << "Aluno destruido!" << endl;
    quantAlunos--;
}
void Aluno::setNome(string n){
    nome = n;
}
string Aluno::getNome(){
    return nome;
}
void Aluno::leiaNome(){
    cout << "Digite o nome do aluno: ";
    getline(cin, nome);
}
void Aluno::leiaAluno(){
    leiaNome();
    dataNascimento.leiaData();
}
void Aluno::imprimeNome(){
    cout << "\nNome: " << nome << endl;
}
void Aluno::imprimeAluno(){
    imprimeNome();
    dataNascimento.imprimeData();
}



void listaAlu(Aluno *aluno[], int quantAlunos){
    for (int i = 0; i < quantAlunos; i++)
    {
        aluno[i]->imprimeAluno();
    }
}

void deletaAluno(Aluno *aluno[], int quantAlunos){
    for (int i = 0; i < quantAlunos; i++)
    {
        delete aluno[i];
    }
}

int menu(){
    int opcao;
    bool erro;
    cout << "BEM VINDO AO MENU!" << endl;
    cout << "0 - Sair" << endl;
    cout << "1 - Cadastrar Aluno" << endl;
    cout << "2 - Listar Alunos" << endl;
    cout << "Digite a operacao que voce deseja fazer: ";
    do
    {
        cin >> opcao;

        if (opcao != 0 && opcao != 1 && opcao != 2)
        {
            erro = true;
            cout << "\aOPCAO INVALIDA!" << endl;
            cout << "Digite novamente: ";
        }
        else
        {
            erro = false;
        }
    } while (erro);

    return opcao;
}


int main(){
    Aluno* alunos[NALUNO];
    
    int opcao;
    do
    {
        opcao = menu();

        switch (opcao)
        {
        case 1:
        {
            alunos[Aluno::quantAlunos] = new Aluno();
            alunos[Aluno::quantAlunos-1]->leiaAluno();

            break;
        }
        case 2:
            listaAlu(alunos, Aluno::quantAlunos);
            break;
        }
    } while (opcao != 0);

    deletaAluno(alunos, Aluno::quantAlunos);
    return 0;
}