package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valorDoOrderStatus(int value) {
		for(OrderStatus orderStatus : OrderStatus.values()) {
			if(value == orderStatus.getCode()) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("Código do OrderStatus não existe...");
	}
}