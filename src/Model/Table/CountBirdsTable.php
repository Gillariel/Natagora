<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountBirds Model
 *
 * @method \App\Model\Entity\CountBird get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountBird newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountBird[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountBird|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountBird patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountBird[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountBird findOrCreate($search, callable $callback = null, $options = [])
 */
class CountBirdsTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('count_birds');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        return $validator;
    }
}
