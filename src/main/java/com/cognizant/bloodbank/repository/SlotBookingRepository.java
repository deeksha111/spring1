package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.model.SlotBooking;


@Repository
public interface SlotBookingRepository extends JpaRepository<SlotBooking, Integer> {
	
	/*@Query(value="select * from user where us_id IN (select ua_us_id_fk from user_address join address on ua_addr_id_fk=addr_id where addr_pincode=:pincode) and us_bloodgroup=:bloodgroup",nativeQuery=true)
	public List<SlotBooking> getSlotList(@Param(value = "bloodgroup") String bloodgroup,@Param(value = "pincode")int pincode);*/

	@Query(value="select count(*) as no_of_patients from hospital h join slot_booking s on h.hp_id = s.sl_hp_id_fk where s.sl_time =:time AND s.sl_date=:date",nativeQuery=true)
	public int getSlotList(@Param(value = "time")int time,@Param(value = "date")int date);
	
	SlotBooking findById(int time);

	public void save(Slot slotBooking);
}
