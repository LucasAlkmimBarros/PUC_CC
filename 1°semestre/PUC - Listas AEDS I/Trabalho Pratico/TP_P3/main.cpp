#include <iostream>
#include <string>



const int NALUNO = 100;

using namespace std;

class Data
{
private:
    int mes;
    int ano;
    int dia;

public:
    Data(int dia, int mes, int ano)
    {
        setData(dia, mes, ano);
    }
    Data()
    {
    }


    void setDia(int dia)
    {
        printf("chegou no dia %i", dia);
        this->dia = dia;
        printf("setouDia");
    }

    void setMes(int mes)
    {

        if (mes <= 12 && mes >= 1)
        {
        printf("cheogu no mes %i", mes);
            this->mes = mes;
            printf("setouMes");
        }
        else
        {
            cout << "\nMês inválido!" << endl;
        }
    }

    void setAno(int ano)
    {
        printf("chegou no ano %i", ano);
        this->ano = ano;
        printf("setouAno");
    }

    int getDia()
    {
        return dia;
    }

    int getMes()
    {
        return mes;
    }

    int getAno()
    {
        return ano;
    }

    void setData(int dia, int mes, int ano)
    {

        this->setDia(dia); 
        printf("cheogu no mes");
        setMes(mes);
        setAno(ano);
    }

    void leiaData()
    {
        int d, m, a;
        cout << "\nData: [dd mm aaaa]\n";
        scanf("%i %i %i", &d, &m, &a);
        this->setData(d, m, a);
    }

    void escrevaData()
    {
        cout << getDia() << "/" << getMes() << "/" << getAno() << endl;
    }

    bool verificaDataValida()
    {
        bool ehValida = true;
        if (ano < 0)
            ehValida = false;
        else if (mes < 1 || mes > 12)
            ehValida = false;
        else
        {
            int qtDiasMes;
            switch (mes)
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
            }

            if (dia < 1 || dia > qtDiasMes)
                ehValida = false;
        }

        return ehValida;
    }
};


class Aluno
{
private:
    Data* dataNascimento;
    string nome;

public:
    static int quantAlunos;
    Aluno()
    {
        dataNascimento = new Data();
        quantAlunos++;
    }
    Aluno(string nome, int d, int m, int a)
    {
        setNome(nome);
        dataNascimento = new Data(d, m, a);
        quantAlunos++;
    }
    ~Aluno()
    {
        delete dataNascimento;
        quantAlunos--;
    }

    void setNome(string nomeLido)
    {
        nome = nomeLido;
    }
    string getNome()
    {
        return this->nome;
    }
    void leiaNome()
    {
        string nomeLido;
        cin.ignore();
        printf("\nDigite o nome: ");
        getline(cin, nomeLido);
        setNome(nomeLido);
    }
    void escrevaNome()
    {
        cout << "Nome do aluno: " << nome << endl;
    }
    void leiaAluno()
    {
        leiaNome();
        this->dataNascimento->leiaData();
    }
    void escrevaAluno()
    {
        escrevaNome();
        dataNascimento->escrevaData();
    }
};
int Aluno::quantAlunos = 0;

void listaAlunos(Aluno *aluno[], int quantAlunos)
{
    for (int i = 0; i < quantAlunos; i++)
    {
        aluno[i]->escrevaAluno();
    }
}

void deletaAluno(Aluno *aluno[], int quantAlunos)
{
    for (int i = 0; i < quantAlunos; i++)
    {
        delete aluno[i];
    }
}


int menu()
{
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

int main()
{
    setlocale(LC_ALL, "Portuguese");
    Aluno *aluno[NALUNO];

    int opcao;
    do
    {
        opcao = menu();

        switch (opcao)
        {
        case 1:
        {
            aluno[Aluno::quantAlunos] = new Aluno();
            printf("\nA QUANTIDADE DE ALUNOS E DE: %i", Aluno::quantAlunos);
            aluno[Aluno::quantAlunos-1]->leiaAluno();

            break;
        }
        case 2:
            listaAlunos(aluno, Aluno::quantAlunos);
            break;
        }
    } while (opcao != 0);

    deletaAluno(aluno, Aluno::quantAlunos);

    return 0;
}