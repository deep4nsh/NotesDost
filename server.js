const express = require('express');
const bodyParser = require('body-parser');
const axios = require('axios');
const app = express();
const PORT = 3000;

app.use(bodyParser.json());

// Replace 'YOUR_OPENAI_API_KEY' with your actual OpenAI API key
const OPENAI_API_KEY = 'YOUR_OPENAI_API_KEY';

// Endpoint for ChatGPT response
app.post('/chatgpt-response', async (req, res) => {
    try {
        const { query } = req.body;

        const response = await axios.post(
            'https://api.openai.com/v1/completions',
            {
                model: 'text-davinci-003', // Or other models like 'gpt-3.5-turbo'
                prompt: query,
                max_tokens: 100
            },
            {
                headers: {
                    'Authorization': `Bearer ${OPENAI_API_KEY}`,
                    'Content-Type': 'application/json'
                }
            }
        );

        const answer = response.data.choices[0].text;
        res.json({ response: answer });
    } catch (error) {
        console.error('Error fetching ChatGPT response:', error);
        res.status(500).json({ error: 'Error fetching response' });
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
