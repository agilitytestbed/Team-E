package agilitytestbed.team.e.dpa.transaction;

import agilitytestbed.team.e.dpa.security.Authenticated;

import javax.persistence.*;

/**
 * @author Martijn Noorlander
 * @since 4-2-2018
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Authenticated authenticated;
}
