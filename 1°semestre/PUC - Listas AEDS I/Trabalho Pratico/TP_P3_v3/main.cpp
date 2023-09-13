#include <iostream>
#include <string>
using namespace std;

const int NALUNO = 50;
const int NPROF = 50;
const int NPESSOAS = 100;

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
        virtual void imprimePessoa();
        bool verificaMes(int m);
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
    fflush(stdin);
    getline(cin, nomeLido);
    setNome(nomeLido);
}
void Pessoa::leiaPessoa(){
    leiaNome();
    dataNascimento.leiaData();
}
void Pessoa::imprimeNome(){
    cout << "Nome: " << nome << endl;
}
void Pessoa::imprimePessoa(){
    imprimeNome();
    dataNascimento.imprimeData();
}
bool Pessoa::verificaMes(int m){
    bool ehIgual = false;
    if(this->dataNascimento.getMes() == m) ehIgual = true;
    return ehIgual;
}
void deletaPessoas(Pessoa *pessoa[], int quantPessoas){
    for (int i = 0; i < quantPessoas; i++)
    {
        delete pessoa[i];
    }
}
//FIM DA CLASSE PESSOA

//COMEÇO DA CLASSE ALUNO
class Aluno : public Pessoa{
    private:
        int matricula; 
    public:
        static int quantAlunos;
        Aluno();
        Aluno(string n, int d, int m, int a);
        ~Aluno();
        void leiaAluno();
        void imprimePessoa();
        void setMatricula(int matriculaLida);
        int getMatricula();
        void leiaMatricula();
        void imprimeMatricula();
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
void Aluno::leiaAluno(){
    leiaMatricula();
    leiaNome();
    dataNascimento.leiaData();
}
void Aluno::imprimePessoa(){
    imprimeMatricula();
    imprimeNome();
    dataNascimento.imprimeData();
}
void Aluno::setMatricula(int matriculaLida){
    this->matricula = matriculaLida;
}
int Aluno::getMatricula(){
    return matricula;
}
void Aluno::leiaMatricula(){
    int matriculaLida;
    printf("\nDigite a matricula: ");
    scanf("%i", &matriculaLida);
    setMatricula(matriculaLida);
}
void Aluno::imprimeMatricula(){
    cout << "\nMatricula: " << matricula << endl;
}

void listaAlunos(Aluno *aluno[], int quantAlunos){
    for (int i = 0; i < quantAlunos; i++)
    {
        aluno[i]->imprimePessoa();
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
        string titulacao;
    public:
        static int quantProfessores;
        Professor();
        Professor(string n, int d, int m, int a);
        ~Professor();    
        void leiaProfessor();
        void imprimePessoa();
        void setTitulacao(string titulacaoLida);
        string getTitulacao();
        void leiaTitulacao();
        void imprimeTitulacao();
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

void Professor::leiaProfessor(){
    leiaTitulacao();
    leiaNome();
    dataNascimento.leiaData();
}
void Professor::imprimePessoa(){
    imprimeTitulacao();
    imprimeNome();
    dataNascimento.imprimeData();
}
void Professor::setTitulacao(string titulacaoLida){
    titulacao = titulacaoLida;
} 

string Professor::getTitulacao(){
    return titulacao;
}
void Professor::leiaTitulacao(){
    string titulacaoLida;
    printf("\nDigite a titulacao: ");
    cin.ignore();
    getline(cin, titulacaoLida);
    setTitulacao(titulacaoLida);
}
void Professor::imprimeTitulacao(){
    cout << "\nTitulacao: " << titulacao << endl;
}

void listaProfessores(Professor *professor[], int quantProfessores){
    for (int i = 0; i < quantProfessores; i++)
    {
        professor[i]->imprimePessoa();
    }
}

void deletaProfessor(Professor *professor[], int quantProfessores){
    for (int i = 0; i < quantProfessores; i++)
    {
        delete professor[i];
    }
}    

//FIM DA CLASSE PROFESSOR

void listaAniversariantes(int mes, Pessoa* pessoas[], int tamanho){
    for(int i = 0; i < tamanho; i++){
        if(pessoas[i]->verificaMes(mes)){
            pessoas[i]->imprimePessoa();
        }
    }
}
  


//COMEÇO DO MENU

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

//FIM DO MENU


int main(){
    Aluno* alunos[NALUNO];
    Professor* professores[NPROF]; 
    Pessoa* pessoas[NPESSOAS];

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
            int quantPessoasTotais = Aluno::quantAlunos + Professor::quantProfessores; 
            for(int i = 0; i < Aluno::quantAlunos; i++){
                pessoas[i] = alunos[i];
            }
            for(int i = Aluno::quantAlunos; i < quantPessoasTotais; i++){
                pessoas[i] = professores[i-Aluno::quantAlunos];
            }
            
            int mes;
            printf("\nDigite o mes: ");
            scanf("%i", &mes);
            listaAniversariantes(mes, pessoas, quantPessoasTotais);
            break;
        }
    } while (opcao != 0);

    deletaAluno(alunos, Aluno::quantAlunos);
    deletaProfessor(professores, Professor::quantProfessores);
    int quantPessoas = Aluno::quantAlunos + Professor::quantProfessores; 
    deletaPessoas(pessoas, quantPessoas);

    return 0;
}