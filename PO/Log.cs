using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Log : UnaryOperation
    {
        public double value;

        public Log(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return Math.Log10(value);
        }

        public override string Result()
        {
            return $"log({value})";
        }
    }
}
