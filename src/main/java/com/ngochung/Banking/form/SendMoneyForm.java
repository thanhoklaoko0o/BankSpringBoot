package com.ngochung.Banking.form;

public class SendMoneyForm {
	
	private Long fromAccountId;
	private Long toAccountId;
	private Double amount;
	public SendMoneyForm() {
		super();
	}
	public SendMoneyForm(Long fromAccountId, Long toAccountId, Double amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
	public Long getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Long getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
