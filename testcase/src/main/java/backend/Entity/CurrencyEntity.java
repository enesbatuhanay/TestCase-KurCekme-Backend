package backend.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_currency")
@Entity
public class CurrencyEntity {

	private static final long serialVersionUID = -3718780555566461094L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "currency_id")
	private long currencyId;

	@Column(name = "currency_code")
	private String currencyCode;

	@Column(name = "unit")
	private int unit;

	@Column(name = "currency_name")
	private String currencyName;

	@Column(name = "forex_buying")
	private double forexBuying;

	@Column(name = "forex_selling")
	private double forexSelling;

	@Column(name = "banknote_buying")
	private double banknoteBuying;
	@Column(name = "banknote_selling")
	private double banknoteSelling;

}

