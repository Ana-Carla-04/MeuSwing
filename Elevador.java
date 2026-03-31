import java.util.Scanner;

public class Elevador {
    //predio do terreo(0) ate 10° andar
    int andarAtual;
    int ultimoAndar;
    //parado, subindo, descendo
    String estado;
    int proxAndar;
    //capacidade de ate 5 pessoas
    int capacidade;
    int capacidadeMax;
    boolean ligado;

    public Elevador(){

    }
    public Elevador(int andarAtual, String estado, int capacidade){
        this.andarAtual=andarAtual;
        this.estado = estado;
        this.capacidade = capacidade;
    }

    void print( int andarAtual, String estado, int capacidade){
        System.out.println("Estado: "+estado+"\n"+"Andar Atual: "+andarAtual+"\n"+"Capacidade: "+capacidade);
    }

    int subir(int andarAtual,int proxAndar,int ultimoAndar){
        if(andarAtual != ultimoAndar && proxAndar<ultimoAndar){
            this.estado = "subindo";
        }
        if(estado.equals("subindo") && proxAndar>andarAtual){
            for (int i = andarAtual;i<ultimoAndar;i++){
                this.andarAtual = proxAndar;}
        }else{
            System.out.println("Andar inválido");
        }
        return this.andarAtual;
    }

    int descer(int andarAtual,int proxAndar, int ultimoAndar){
        if ( andarAtual != 0 && proxAndar>ultimoAndar){
            this.estado = "descendo";
        }
        if(estado.equals("descendo") && proxAndar<andarAtual){
            for (int i = andarAtual;i> ultimoAndar ;i--){
                this.andarAtual = proxAndar;}
        }else{
            System.out.println("Andar inválido");
        }
        return this.andarAtual;
    }

    //parar

    int entrarPessoa(int capacidade){
        if(capacidade == capacidadeMax){
            System.out.println("Elevador cheio");
        }else{
            this.capacidade = capacidade +1;
        }
        return this.capacidade;
    }

    int sairPessoa(int capacidade){
        if(capacidade == 0){
            System.out.println("Elevador vazio");
        }else{
            this.capacidade = capacidade - 1;
        }
        return this.capacidade;
    }

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        Elevador Elev = new Elevador(0,"parado",0);
        

        System.out.println("Digite quantos andares tem o prédio:");
        Elev.ultimoAndar = leitor.nextInt();
        System.out.println("Digite a capacidade maxíma de pessoas no elevador:");
        Elev.capacidadeMax = leitor.nextInt();
        Elev.ligado = true;
        int entrada = 0;

        while (Elev.ligado){

            Elev.print(Elev.andarAtual,Elev.estado,Elev.capacidade);

            System.out.println("-----------------------------------\n"+
                "Escolha uma opção: \n"+
                "1 - Entrar uma pessoa no elevador\n"+
                "2 - Sair um pessoa do elevador\n"+
                "3 - Subir até...\n"+
                "4 - Descer até...\n"+
                "5 - Desligar elevador\n"+
                "-----------------------------------");
            entrada = leitor.nextInt();
            if(entrada == 1){
                Elev.entrarPessoa(Elev.capacidade);
                
            }else if(entrada == 2){
                Elev.sairPessoa(Elev.capacidade);
            }else if(entrada == 3){
                System.out.print("Para qual andar deseja subir?");
                Elev.proxAndar = leitor.nextInt();
                Elev.andarAtual = Elev.subir(Elev.andarAtual,Elev.proxAndar,Elev.ultimoAndar);
            }else if(entrada == 4){
                System.out.print("Para qual andar deseja descer?");
                Elev.proxAndar = leitor.nextInt();
                Elev.andarAtual = Elev.descer(Elev.andarAtual,Elev.proxAndar,Elev.ultimoAndar);
            }else if(entrada == 5){
                Elev.ligado = false;
            }else{
                System.out.println("Comando inválido.");
            }
        }
        leitor.close();
    }



}
