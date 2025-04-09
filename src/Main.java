public class Main {
    public static void main(String[] args) {
        SistemaPagamento pagamento = new SistemaPagamento();

        IMetodoPagamento cartao = new PagamentoCartao();
        IMetodoPagamento pix = new PagamentoPix();
        IMetodoPagamento boleto = new PagamentoBoleto();

        pagamento.realizarPagamento(0, cartao);
        pagamento.realizarPagamento(0, pix);
        pagamento.realizarPagamento(0, boleto);
    }
}