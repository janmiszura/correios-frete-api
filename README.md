# Correios Api (Frete: Preço/Prazo)

API para cálculo de frete nos Correios com função embalador de produtos.

## Exemplo

```java

List<ResultadoFrete> resultados = CorreiosFrete
				.novo()
				.comTipoServico(TipoServico.PAC.getCodigo())
				.comCepOrigemDestino("74371520", "74672540")
				.addEmbalagem(Embalagem.CORREIOS_TIPO_4)
				.addItem(new Item(20, 12, 5, 1), 1)
				.calcPrecoPrazo()
				;

```

## TODO list

1. Melhorar embalador de itens (embalagens de tamanhos diferentes)
2. Implementar limitador quanto ao número de embalagens
3. Implementar formato Rolo/Prisma
4. Implementar formato Envelope

