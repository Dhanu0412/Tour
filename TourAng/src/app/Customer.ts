export interface Customer {
    customerID: number,
    customerName: {
        fname: string,
        lname: string
    },
    gender: string,
    password: string,
    username: string,
    email: string,
    dateOfBirth: number,
    phone: number,
    address: {
        addressID: number,
        doorno: number,
        street: string,
        city: string,
        pincode: number
    }
}