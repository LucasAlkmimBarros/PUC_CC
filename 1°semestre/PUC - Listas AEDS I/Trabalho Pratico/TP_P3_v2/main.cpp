#include <iostream>
#include <string>
using namespace std;

const int NALUNO = 100;
const int NPROF = 100;

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
Data::~Data(){}
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
    printf("pegou dia %i\n", dia);
    return dia;
}
int Data::getMes(){
    printf("pegou mes %i\n", mes);
    return mes;
}
int Data::getAno(){
    printf("pegou ano %i\n", ano);
    return ano;
}
void Data::leiaData(){
    int d, m, a;
    bool erro;
    do
    {
        printf("Digite a data (dd/mm/aaaa): ");
        scanf("%i/%i/%i", &d, &m, &a);

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
    cout << "Data: "<< dia << "/" << mes << "/" << ano << endl;
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

//COMEÇO DA CLASSE PESSOA
class Pessoa{
    protected:
        string nome;
        Data dataNascimento;
    public:
        static int quantPessoas;
        Pessoa();
        Pessoa(string n, int d, int m, int a);
        ~Pessoa();
        void setNome(string n);
        string getNome();
        void leiaNome();
        void leiaPessoa();
        void imprimeNome();
        void imprimePessoa();
};
int Pessoa::quantPessoas = 0;
Pessoa::Pessoa(){
    nome = "";
    quantPessoas++;
}
Pessoa::Pessoa(string n, int d, int m, int a){
    nome = n;
    dataNascimento.setData(d, m, a);
    quantPessoas++;
}
Pessoa::~Pessoa(){
    quantPessoas--;
}
void Pessoa::setNome(string nomeLido){
    nome = nomeLido;
}
string Pessoa::getNome(){
    return nome;
}
void Pessoa::leiaNome(){
    string nomeLido;
    printf("Digite o nome: ");
    cin.ignore();
    getline(cin, nomeLido);
    setNome(nomeLido);
}
void Pessoa::leiaPessoa(){
    leiaNome();
    dataNascimento.leiaData();
}
void Pessoa::imprimeNome(){
    cout << "\nNome: " << nome << endl;
}
void Pessoa::imprimePessoa(){
    imprimeNome();
    dataNascimento.imprimeData();
}

//FIM DA CLASSE PESSOA

//COMEÇO DA CLASSE ALUNO
class Aluno : public Pessoa{
    private:
        Data dataNascimento;
        string nome;
        int matricula; 
    public:
        static int quantAlunos;
        Aluno();
        Aluno(string n, int d, int m, int a);
        ~Aluno();
        void setNomeAluno(string n);
        string getNomeAluno();
        void leiaNomeAluno();
        void leiaAluno();
        void imprimeNomeAluno();
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
    quantAlunos--;
}
void Aluno::setNomeAluno(string nomeLido){
    nome = nomeLido;
}
string Aluno::getNomeAluno(){
    return nome;
}
void Aluno::leiaNomeAluno(){
    string nomeLido;
    printf("\nDigite o nome do aluno: ");
    cin.ignore();
    getline(cin, nomeLido);
    setNomeAluno(nomeLido);
}
void Aluno::leiaAluno(){
    leiaNomeAluno();
    dataNascimento.leiaData();
}
void Aluno::imprimeNomeAluno(){
    cout << "\nNome: " << nome << endl;
}
void Aluno::imprimeAluno(){
    imprimeNomeAluno();
    dataNascimento.imprimeData();
}



void listaAlunos(Aluno *aluno[], int quantAlunos){
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
//FIM DA CLASSE ALUNO




//COMEÇO DA CLASSE PROFESSOR
class Professor : public Pessoa{
    private:
        Data dataNascimento;
        string nome;
        int titulacao;; 
    public:
        static int quantProfessores;
        Professor();
        Professor(string n, int d, int m, int a);
        ~Professor();
        void setNomeProf(string n);
        string getNomeProf();
        void leiaNomeProf();
        void leiaProfessor();
        void imprimeNomeProf();
        void imprimeProfessor();
};
int Professor::quantProfessores = 0;
Professor::Professor(){
    nome = "";
    quantProfessores++;
}
Professor::Professor(string n, int d, int m, int a){
    nome = n;
    dataNascimento.setData(d, m, a);
    quantProfessores++;
}
Professor::~Professor(){
    quantProfessores--;
}
void Professor::setNomeProf(string nomeLido){
    nome = nomeLido;
}
string Professor::getNomeProf(){
    return nome;
}
void Professor::leiaNomeProf(){
    string nomeLido;
    printf("\nDigite o nome do professor: ");
    cin.ignore();
    getline(cin, nomeLido);
    setNomeProf(nomeLido);
}
void Professor::leiaProfessor(){
    leiaNomeProf();
    dataNascimento.leiaData();
}
void Professor::imprimeNomeProf(){
    cout << "\nNome: " << nome << endl;
}
void Professor::imprimeProfessor(){
    imprimeNomeProf();
    dataNascimento.imprimeData();
}



void listaProfessores(Professor *professor[], int quantProfessores){
    for (int i = 0; i < quantProfessores; i++)
    {
        professor[i]->imprimeProfessor();
    }
}

void deletaProfessor(Professor *professor[], int quantProfessores){
    for (int i = 0; i < quantProfessores; i++)
    {
        delete professor[i];
    }
}

//FIM DA CLASSE PROFESSOR


int menu(){
    int opcao;
    bool erro;
    cout << "\nBEM VINDO AO MENU!" << endl;
    cout << "0 - Sair" << endl;
    cout << "1 - Cadastrar Aluno" << endl;
    cout << "2 - Cadastrar Professor" << endl;
    cout << "3 - Listar Alunos" << endl;
    cout << "4 - Listar Professores" << endl;
    cout << "5 - Listar Aniversariantes do mes" << endl;

    cout << "Digite a operacao que voce deseja fazer: ";
    do
    {
        cin >> opcao;

        if (opcao != 0 && opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5)
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
    Professor* professores[NPROF]; 


    int opcao;
    do
    {
        opcao = menu();

        switch (opcao)
        {
        case 1:
        {
            alunos[Aluno::quantAlunos-1] = new Aluno();
            alunos[Aluno::quantAlunos-1]->leiaAluno();
            break;
        }
        case 2:
        {
            professores[Professor::quantProfessores-1] = new Professor();
            professores[Professor::quantProfessores-1]->leiaProfessor();
            break;
        }
        case 3:
            listaAlunos(alunos, Aluno::quantAlunos);
            break;
        case 4:
            listaProfessores(professores, Professor::quantProfessores);
            break;
        case 5:
            break;
        }
    } while (opcao != 0);

    deletaAluno(alunos, Aluno::quantAlunos);
    deletaProfessor(professores, Professor::quantProfessores);

    return 0;
}