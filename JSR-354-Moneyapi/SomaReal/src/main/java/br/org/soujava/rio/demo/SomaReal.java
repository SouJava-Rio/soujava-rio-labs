/*
 * The MIT License
 * Copyright © 2018 Daniel Dias
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.org.soujava.rio.demo;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

/**
 * @author <a href="mailto:daniel.dias@soujava.org.br">Daniel Dias</a>
 * github:Daniel-Dos 
 * twitter:@danieldiasjava
 */
public class SomaReal {
    public static void main(String[] args) {

        // criar um unidade monetaria
        var real = Monetary.getCurrency("BRL");

        // criar quantia monetária
        var monetaryAmount = Money.of(1202.12D, real);
        var monetaryAmount2 = Money.of(500D, real);

        // operacao com dinheiro
        var soma = monetaryAmount.add(monetaryAmount2);

        // criando uma formação customizada para PT-BR
        var customFormat = MonetaryFormats.getAmountFormat(AmountFormatQueryBuilder.of(new Locale("pt","br")).set(CurrencyStyle.SYMBOL).build());

        System.out.println(customFormat.format(soma)); //R$ 1.702,12
    }
}