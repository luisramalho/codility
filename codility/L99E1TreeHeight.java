/*
 * The MIT License
 *
 * Copyright 2014 luisramalho.
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
package codility;

/**
 * Compute the height of a binary link-tree.
 *
 * @author luisramalho
 */
public class L99E1TreeHeight {

    /**
     * Returns the height of a tree according to the convention that a tree
     * consisting only of just one node has height 0.
     *
     * @param T the tree
     * @return the height of the tree
     */
    public int solution(Tree T) {
        return treeHeight(T) - 1;
    }

    /**
     * Computes the height of a binary link-tree.
     *
     * @param T the tree
     * @return the height of a binary link-tree.
     */
    private int treeHeight(Tree T) {
        if (T == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(T.l), treeHeight(T.r));
    }
}
