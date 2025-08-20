public abstract class ObservableSort<T> {
    private SortObserver observer;
    private int contadorComparacao = 0;
    private int contadorTrocas = 0;

    public void setObserver(SortObserver observer) {
        this.observer = observer;
    }
    
    public int getContadorComparacao() {
        return contadorComparacao;
    }
    public int getContadorTrocas() {
        return contadorTrocas;
    }

    protected void notificarComparacao(int indice1, int indice2){
        this.contadorComparacao++;
        if(observer!=null)
          observer.aoComparar(indice1, indice2);
    }

    protected void notificarTroca(int indice1, int indice2){
        this.contadorTrocas++;
        if(observer!=null)
            observer.aoTrocar(indice1, indice2);
    }

    protected  void notificarConclusao(){
        if(observer!=null)
            observer.aoConcluir(contadorComparacao, contadorTrocas);
    }

}
