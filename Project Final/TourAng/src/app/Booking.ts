export interface Booking {
    packBookID: number;
    noOfDays: number;
    noOfPeope: number;
    packageCost: number;
    startDate: Date;
    endDate: Date;
    bookingDate: Date;
    pack: {
        packageID: number;
        packageName: string;
        itenary: string;
        location: string;
        hotelName: string;
        hotelCostPerDay: number;
        costPerDay: number;
    };
    customer: {
        customerID: number;
        customerName: {
            fname: string;
            lname: string;
        };
        gender: string;
        password: string;
        email: string;
        dateOfBirth: Date;
        phone: string;
        address: {
            doorno: number;
            street: string;
            city: string;
            pincode: number
        }
    }
}
