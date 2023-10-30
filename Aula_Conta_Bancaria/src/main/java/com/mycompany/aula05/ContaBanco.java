package com.mycompany.aula05;
/**
 *
 * Classe de criação de conta de banco
 * aula 05 do curso em vídeo (JAVA POO) * 
 */
public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    public void estadoAtual(){
        System.out.println("----------------------------");
        System.out.println("Conta: " + this.getNumConta());        
        System.out.println("Tipo: " + this.getTipo());        
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

/**
 *   MÉTODOS
 */     
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        //informar cc ou cp. se cc = R%50,00, cp = R$150,00
        if(t == "CC") {
            this.setSaldo(50);
        } else if (t == "CP") {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }
    
    public void fecharConta() {
        //saldo precisa ser 0
        if (this.getSaldo() > 0) {
            System.out.println("Conta com dinheiro!");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta em DEBITO!");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }
    
    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo((float) (this.getSaldo() + v));
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("IMPOSSÍVEL DEPOSITAR (NÃO EXISTE CONTA)");
        }
    }
    
    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo((float) (this.getSaldo() - v));
                System.out.println("Saque realizado na conta de: " + this.getDono());
            } else {
                System.out.println("Saldo Insuficiente para saque");
            }
        } else {
            System.out.println("Impossível Sacar (Conta inexistente)");
        }
        //checar se o status é true e se há saldo suficiente
    }
    
    public void pagarMensal() { 
        // cc = R$12, cp = R$20
        int v = 0;
        
        if(this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP") {
            v = 20;
        }
        if(this.getStatus()) {
                this.setSaldo((float) (this.getSaldo() - v));                
                System.out.println("Mensalidade paga com sucesso por: " + this.getDono());
            } else{
                System.out.println("Impossível pagar uma conta fechada!");
            }
    }
    
 
/**
 * MÉTODOS ESPECIAIS
 * SETTERS E GETTERS
 */
 
    //construtor: status = falso, saldo = 0
    public void ContaBanco() {
        this.setStatus(false);
        this.setSaldo(0);
    }

    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDono() {
    return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    
    public double getSaldo() {
       return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    } 
    
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
