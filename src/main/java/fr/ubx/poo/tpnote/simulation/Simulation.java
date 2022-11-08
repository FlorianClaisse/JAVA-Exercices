package fr.ubx.poo.tpnote.simulation;
import fr.ubx.poo.tpnote.subscription.*;
import fr.ubx.poo.tpnote.subscription.SubscriptionLevel;


public class Simulation {
	public static void main(String[] args)  {
		System.out.println("--------------------------------------------------");
		IndividualSubscription is1 = new IndividualSubscription("p@t.fr", SubscriptionLevel.STUDENT);
		IndividualSubscription is2 = new IndividualSubscription("u@g.fr");
		IndividualSubscription is3 = new IndividualSubscription("t@y.fr", SubscriptionLevel.PREMIUM);
		FamilySubscription fs1 = new FamilySubscription("e@r.fr", 6);
		FamilySubscription fs2 = new FamilySubscription("d@h.fr", 6);

		System.out.println("cost of student subscription is1 per month : " + is1.getCost());
		System.out.println("nb users of individual subscription is1 : " + is1.getNbUsers());
		System.out.println(is1);

		System.out.println(fs1.addUsers(3) + " users added");
		System.out.println(fs1.addUser() + " user added");
		System.out.println(fs2.addUsers(5) + " users added");

		System.out.println("cost of family subscription per month : " + fs1.getCost());
		System.out.println("nb users of family subscription fs1 : " + fs1.getNbUsers());
		System.out.println(fs1);

		SubscriptionsSet set = new SubscriptionsSet();

		if (set.addSubscription(is1)
				&& set.addSubscription(is2)
				&& set.addSubscription(is3)
				&& set.addSubscription(fs1)
				&& set.addSubscription(fs2))
			System.out.print(set);
		else {
			System.out.println("At least one Subscription object couldn't be added");
			return;
		}
		System.out.println("mean cost per user : " + set.getMeanAnnualCostPerUser());
		System.out.println();
		int added = fs1.addUsers(3);
		System.out.println(added + " more users");
		System.out.println();
		System.out.print(set);
	}
}

