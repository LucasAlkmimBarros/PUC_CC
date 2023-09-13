#include <iostream>
#include <string>
#include <locale.h>

const int NALUNO = 100;

using namespace std;

class Data
{
private:
    int dia;
    int mes;
    int ano;

public:
    Data(int dia, int mes, int ano)
    {
        setData(dia, mes, ano);
    }

    bool setDia(int dia)
    {
        if (dia <= 31 && dia >= 1)
        {
            this->dia = dia;
            return true;
        }
        else
        {
            cout << "\nDia inválido!" << endl;
            return false;
        }
    }

    bool setMes(int mes)
    {
        if (mes <= 12 && mes >= 1)
        {
            this->mes = mes;
            return true;
        }
        else
        {
            cout << "\nMês inválido!" << endl;
            return false;
        }
    }

    void setAno(int ano)
    {
        this->ano = ano;
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
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    void leiaData()
    {
        int d, m, a;
        cout << "\nData: [dd/mm/aaaa]\n";
        cin >> d >> m >> a;
        setData(d, m, a);
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
    string nome;
    Data *dataNascimento;

public:
    Aluno(const string &nome, int dia, int mes, int ano)
    {
        setNome(nome);
        dataNascimento = new Data(dia, mes, ano);
    }

    ~Aluno()
    {
        delete dataNascimento;
    }

    void setNome(const string &nome)
    {
        this->nome = nome;
    }

    const string &getNome() const
    {
        return nome;
    }

    void leiaNome()
    {
        cout << "\nDigite o nome do Aluno: ";
        cin.ignore();
        getline(cin, nome);
    }
    void escrevaNome()
    {
        cout << "Nome do aluno: " << nome << endl;
    }

    void leiaAluno()
    {
        leiaNome();
        dataNascimento->leiaData();
    }

    void escrevaAluno()
    {
        escrevaNome();
        dataNascimento->escrevaData();
    }
};

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
    cout << "Digite a operação que você deseja fazer: ";
    do
    {
        cin >> opcao;

        if (opcao != 0 && opcao != 1 && opcao != 2)
        {
            erro = true;
            cout << "\aOPÇÃO INVÁLIDA!" << endl;
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
    setlocale(LC_ALL, "pt_BR.UTF-8");

    Aluno *aluno[NALUNO];
    int quantAlunos = 0;
    int opcao;
    do
    {
        opcao = menu();

        switch (opcao)
        {
        case 1:
        {
            if (quantAlunos < NALUNO)
            {
                string nome;
                int dia, mes, ano;

                cout << "\nDigite o nme do aluno: ";
                cin.ignore();
                getline(cin, nome);

                cout << "Digite a data de nascimento (dd mm aaaa): ";
                cin >> dia >> mes >> ano;

                aluno[quantAlunos] = new Aluno(nome, dia, mes, ano);
                quantAlunos++;
            }
            else
            {
                cout << "\nLimite máximo de alunos alcançado!" << endl;
            }
            break;
        }
        case 2:
            listaAlunos(aluno, quantAlunos);
            break;
        }
    } while (opcao != 0);

    deletaAluno(aluno, quantAlunos);

    return 0;
}
