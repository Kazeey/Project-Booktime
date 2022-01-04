import axios from 'axios';
import apiURL from '../../utils/constants/index';

export default {

    getBooksList: () => {
        try
        {
            const response = axios.get(apiURL + '/book/findall');
            return response.data;
        }
        catch (error)
        {
            throw error;
        }
    },

    getBookById: (id) => {
        try
        {
            const response = axios.get(apiURL + '/book/findById/' + id);
            return response.data;
        }
        catch (error)
        {
            throw error;
        }
    }
}