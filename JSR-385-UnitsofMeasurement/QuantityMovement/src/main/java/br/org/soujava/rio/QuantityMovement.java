/*
 * The MIT License
 * Copyright © 2017 Daniel Dias
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
package br.org.soujava.rio;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

/**
 * @author <a href="mailto:daniel.dias@soujava.org.br">Daniel Dias</a>
 * github:Daniel-Dos
 * twitter:@danieldiasjava
 */
public class QuantityMovement {
	public static void main(String[] args) {

		// Q = mv
		var massa = Quantities.getQuantity(2,Units.KILOGRAM);
		var velocidade = Quantities.getQuantity(1, Units.METRE_PER_SECOND);
		var quantidadeMovimento = massa.multiply(velocidade);
		System.out.println(quantidadeMovimento);
	}
}