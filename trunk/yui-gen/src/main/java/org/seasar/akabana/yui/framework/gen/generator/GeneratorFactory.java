/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.generator;



/**
 * @author tango
 *
 */
public class GeneratorFactory {

	/**
     * ジェネレータを作成します。
     * 
     * @param templateEncoding
     *            テンプレートファイルのエンコーディング
     * @param templatePrimaryDir
     *            テンプレートファイルを格納したプライマリディレクトリ、プライマリディレクトリを使用しない場合{@code null}
     * @return ジェネレータ
     */
    public static Generator createGenerator() {
        return new Generator();
    }
    
}
