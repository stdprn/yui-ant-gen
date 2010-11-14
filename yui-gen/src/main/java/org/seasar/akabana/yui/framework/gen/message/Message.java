/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.message;

/**
 * @author tango
 *
 */
public enum Message implements MessageResource {

	YUIGEN0001("パラメータ[{0}]がnullです。"),
    YUIGEN0002("ファイルを作成しました。{0}"),
    YUIGEN0003("ファイルを上書きしました。{0}"),
    YUIGEN0004("ファイルが存在するため上書きしませんでした。{0}"),
    YUIGEN9001("例外が発生しました。{0}"), ;

    private final String messagePattern;

    private Message(String messagePattern) {
        this.messagePattern = messagePattern;
    }

	/**
	 * {@inheritDoc}
	 * @see org.seasar.akabana.yui.framework.gen.message.MessageResource#getCode()
	 */
	@Override
	public String getCode() {
		return name();
	}

	/**
	 * {@inheritDoc}
	 * @see org.seasar.akabana.yui.framework.gen.message.MessageResource#getMessagePattern()
	 */
	@Override
	public String getMessagePattern() {
		return messagePattern;
	}

	/**
	 * {@inheritDoc}
	 * @see org.seasar.akabana.yui.framework.gen.message.MessageResource#getMessage(java.lang.Object[])
	 */
	@Override
	public String getMessage(Object... args) {
		return MessageFormatter.getMessage(this, args);
	}

}
